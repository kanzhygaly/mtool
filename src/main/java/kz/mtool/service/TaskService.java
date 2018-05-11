package kz.mtool.service;

import java.util.List;
import kz.mtool.domain.Task;

/**
 *
 * @author yerlana
 */
public interface TaskService {
    
    List<Task> listAll();

    Task getById(Long id);

    Task saveOrUpdate(Task task);

    void delete(Long id);

    Task newTask(Task task);
    
    Task updateTask(Task task);
    
    void finishTask(Task task);
}
