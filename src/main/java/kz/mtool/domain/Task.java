package kz.mtool.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import kz.mtool.util.Status;

/**
 *
 * @author yerlana
 */
@Entity
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;    
    private String name;
    @Lob
    private String description;
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Status status;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date timeAdded;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
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

    @Override
    public String toString() {
        return "Task\n[" + id + ": " + name + "]";
    }        
}
