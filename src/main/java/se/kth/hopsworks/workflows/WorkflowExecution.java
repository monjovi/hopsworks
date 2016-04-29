package se.kth.hopsworks.workflows;

import org.codehaus.jackson.annotate.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;
import se.kth.hopsworks.user.model.Users;

@Entity
@Table(name = "hopsworks.workflow_executions")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "WorkflowExecution.find",
                query
                        = "SELECT e FROM WorkflowExecution e WHERE e.id = :id AND e.workflowId = :workflowId")})
public class WorkflowExecution implements Serializable {

    public WorkflowExecution(){}

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @XmlElement(name = "id")
    private Integer id;
    public Integer getId() {
        return id;
    }

    @Basic(optional = false)
    @Column(name = "job_id", nullable = false, length = 255)
    private String jobId;
    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    @Basic(optional = false)
    @NotNull
    @Column(name = "workflow_id", nullable = false)
    private Integer workflowId;
    public Integer getWorkflowId() {
        return workflowId;
    }
    public void setWorkflowId(Integer workflowId) {
        this.workflowId = workflowId;
    }

    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id", nullable = false)
    private Integer userId;
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic(optional = false)
    @Column(name = "workflow_timestamp")
    private Date workflowTimestamp;
    public Date getWorkflowTimestamp() {
        return workflowTimestamp;
    }

    public void setWorkflowTimestamp(Date workflowTimestamp) {
        this.workflowTimestamp = workflowTimestamp;
    }

    @Basic(optional = false)
    @Column(name = "error", nullable = false)
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkflowExecution workflowExecution = (WorkflowExecution) o;

        if (id != null ? !id.equals(workflowExecution.id) : workflowExecution.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        return result;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @PrimaryKeyJoinColumn(name="workflow_id")
    private Workflow workflow;

    @ManyToOne(fetch=FetchType.LAZY)
    @PrimaryKeyJoinColumn(name="user_id")
    private Users user;
    @JsonIgnore
    @XmlTransient
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @JsonIgnore
    @XmlTransient
    public Workflow getWorkflow() {
        return workflow;
    }

    public void setWorkflow(Workflow workflow) {
        this.workflow = workflow;
    }

    @OneToOne(fetch=FetchType.LAZY)
    @PrimaryKeyJoinColumn(name="job_id")
    private WorkflowJob job;

    public WorkflowJob getJob() {
        return job;
    }
}
