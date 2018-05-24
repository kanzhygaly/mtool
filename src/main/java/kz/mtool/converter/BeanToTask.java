package kz.mtool.converter;

import kz.mtool.bean.TaskBean;
import kz.mtool.domain.Task;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 *
 * @author yerlana
 */
@Component
public class BeanToTask implements Converter<TaskBean, Task> {

    @Override
    public Task convert(@NonNull TaskBean bean) {
        Task task = new Task();
        task.setId(bean.getId());
        task.setName(bean.getName());
        task.setDescription(bean.getDescription());
        task.setStatus(bean.getStatus());
        task.setTimeAdded(bean.getTimeAdded());
        task.setTimeFinished(bean.getTimeFinished());
        return task;
    }
}
