package kz.mtool.controller;

import javax.validation.Valid;
import kz.mtool.bean.TaskBean;
import kz.mtool.converter.BeanToTask;
import kz.mtool.converter.TaskToBean;
import kz.mtool.domain.Task;
import kz.mtool.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author yerlana
 */
@Controller
public class TaskController {

    private TaskService taskService;
    private TaskToBean taskToBean;
    private BeanToTask beanToTask;

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @Autowired
    public void setTaskToBean(TaskToBean taskToBean) {
        this.taskToBean = taskToBean;
    }

    @Autowired
    public void setBeanToTask(BeanToTask beanToTask) {
        this.beanToTask = beanToTask;
    }

    @RequestMapping("/")
    public String redirectToList() {
        return "redirect:/task/list";
    }

    @RequestMapping({"/task/list", "/task"})
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskService.listAll());
        return "task/list";
    }

    @RequestMapping("/task/view/{id}")
    public String viewTask(@PathVariable String id, Model model) {
        model.addAttribute("task", taskService.getById(Long.valueOf(id)));
        return "task/view";
    }

    @RequestMapping("task/edit/{id}")
    public String editTask(@PathVariable String id, Model model) {
        Task task = taskService.getById(Long.valueOf(id));
        TaskBean taskBean = taskToBean.convert(task);

        model.addAttribute("taskBean", taskBean);
        return "task/taskform";
    }

    @RequestMapping("/task/new")
    public String newTask(Model model) {
        model.addAttribute("taskBean", new TaskBean());
        return "task/taskform";
    }

    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public String saveOrUpdateTask(@Valid TaskBean taskBean, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "task/taskform";
        }

        Task task = beanToTask.convert(taskBean);

        if (taskBean.getTimeAdded() == null) {
            taskService.newTask(task);
        } else {
            taskService.updateTask(task);
        }

        return "redirect:/task/list";
    }

    @RequestMapping(value = "/task/done", method = RequestMethod.POST)
    public String finishTask(Task task, BindingResult bindingResult) {

        taskService.finishTask(task);

        return "redirect:/task/view/" + task.getId();
    }

    @RequestMapping("/task/delete/{id}")
    public String delete(@PathVariable String id) {
        taskService.delete(Long.valueOf(id));
        return "redirect:/task/list";
    }
}
