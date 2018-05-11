package kz.mtool.service;

import java.util.Date;
import java.util.List;
import kz.mtool.domain.Task;
import kz.mtool.repository.TaskRepository;
import kz.mtool.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yerlana
 */
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> listAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task getById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public Task saveOrUpdate(Task task) {
        taskRepository.save(task);
        return task;
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task newTask(Task task) {
        task.setStatus(Status.NEW);
        task.setTimeAdded(new Date());
        
        return saveOrUpdate(task);
    }
    
    @Override
    public Task updateTask(Task task) {
        task.setStatus(Status.UPDATED);
        
        return saveOrUpdate(task);
    }
    
    @Override
    public void finishTask(Task task) {
        task = getById(task.getId());
        
        task.setStatus(Status.COMPLETED);
        task.setTimeFinished(new Date());
        
        saveOrUpdate(task);
    }
}
