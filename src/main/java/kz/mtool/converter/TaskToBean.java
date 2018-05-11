package kz.mtool.converter;

import kz.mtool.bean.TaskBean;
import kz.mtool.domain.Task;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author yerlana
 */
@Component
public class TaskToBean implements Converter<Task, TaskBean> {

    @Override
    public TaskBean convert(Task task) {
        TaskBean bean = new TaskBean();
        bean.setId(task.getId());
        bean.setName(task.getName());
        bean.setDescription(task.getDescription());
        bean.setStatus(task.getStatus());
        bean.setTimeAdded(task.getTimeAdded());
        bean.setTimeFinished(task.getTimeFinished());
        return bean;
    }
}
