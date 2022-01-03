package test.todo.model.dto;

import lombok.Getter;
import lombok.Setter;
import test.todo.model.entity.Status;

import javax.validation.constraints.NotBlank;

public class WorkDto {
    private long id;
    @NotBlank(message = "trường này không được để trống")
    private String workName;
    @NotBlank(message = "trường này không được để trống")
    private String startingDate;
    @NotBlank(message = "trường này không được để trống")
    private String endingDate;
    private Status status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public String getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(String endingDate) {
        this.endingDate = endingDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
