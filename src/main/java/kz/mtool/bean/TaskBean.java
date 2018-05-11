package kz.mtool.bean;

import java.util.Date;
import kz.mtool.util.Status;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author yerlana
 */
public class TaskBean {
    
    private Long id;
    private String name;
    private String description;
    private Status status;
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss.S")
    private Date timeAdded;
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss.S")
    private Date timeFinished;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(Date timeAdded) {
        this.timeAdded = timeAdded;
    }

    public Date getTimeFinished() {
        return timeFinished;
    }

    public void setTimeFinished(Date timeFinished) {
        this.timeFinished = timeFinished;
    }
}
