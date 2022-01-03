package test.todo.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import test.todo.model.entity.Work;
import test.todo.model.repository.IWorkRepository;

import java.util.Optional;

@Service
public class WorkService implements IWorkService {
    @Autowired
    private IWorkRepository workRepository;
    @Override
    public Work saveWork(Work work) {
        return workRepository.save(work) ;
    }

    @Override
    public Page<Work> getWorkByName(String workName, Pageable pageable) {
        return workRepository.findWorkByWorkName(workName,pageable);
    }

    @Override
    public void deleteWork(Long id) {
        workRepository.deleteById(id);

    }

    @Override
    public Work updateWork(Work work) {

        return workRepository.save(work);
    }

    @Override
    public Optional<Work> findWorkById(Long id) {
        return workRepository.findById(id);
    }
}
