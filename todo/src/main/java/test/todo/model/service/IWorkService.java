package test.todo.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import test.todo.model.entity.Work;

import java.util.Optional;

public interface IWorkService {
    Work saveWork(Work work);
    Page<Work>getWorkByName(String workName, Pageable pageable);
    void deleteWork(Long id);
    Work updateWork(Work work);
    Optional<Work> findWorkById(Long id);


}
