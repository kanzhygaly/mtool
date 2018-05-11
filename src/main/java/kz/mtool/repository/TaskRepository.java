package kz.mtool.repository;

import kz.mtool.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yerlana
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
}
