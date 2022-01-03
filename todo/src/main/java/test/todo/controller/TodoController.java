package test.todo.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import test.todo.model.dto.WorkDto;
import test.todo.model.entity.Work;
import test.todo.model.service.IWorkService;
import test.todo.model.service.WorkService;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/work")
public class TodoController {
    @Autowired
    private IWorkService workService;
    @PostMapping("/add")
    public ResponseEntity<Work>saveWork(@Valid @RequestBody WorkDto workDto, BindingResult bindingResult){
        Work work= new Work();
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BeanUtils.copyProperties(workDto,work);
        return new ResponseEntity<>(workService.saveWork(work),HttpStatus.OK);
    }
    @PatchMapping("/update")
    public  ResponseEntity<Work>updateWork(@RequestParam Long id,@Valid @RequestBody WorkDto workDto,BindingResult bindingResult){
        Optional<Work> work = workService.findWorkById(id);
        if (work ==null){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Work work1 = new Work();
        workDto.setId(work.get().getId());
        BeanUtils.copyProperties(workDto, work1);
        return  new ResponseEntity<>(workService.updateWork(work1),HttpStatus.OK);
    }
    @GetMapping("/find")
    public ResponseEntity<Page<Work>> findWorkByName(@RequestParam Optional<String> workName,@RequestParam Optional<Integer> page,
                                                     @RequestParam Optional<String> sortBy){

        Pageable pageable= PageRequest.of(page.orElse(0),5, Sort.Direction.ASC,sortBy.orElse("id"));
        Page<Work> workPage = workService.getWorkByName(workName.orElse(""),pageable);
        if (workPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(workPage, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public  ResponseEntity<Work> deleteWork(@RequestParam Long id){
        Optional<Work> work = workService.findWorkById(id);
        if (work.get() ==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        workService.deleteWork(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }





}
