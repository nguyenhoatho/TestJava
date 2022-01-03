package test.todo.model.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import test.todo.model.entity.Work;
@Repository
public interface IWorkRepository extends JpaRepository<Work,Long> {
   @Query("select work from Work as work where work.workName like %?1%")
   Page<Work> findWorkByWorkName(String name,Pageable pageable);
}
