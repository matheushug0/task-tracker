import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private static int lastTaskId = 0;
    private int id;
    private String description;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    //Date Formater
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

    public Task(String description) {
        this.id = ++lastTaskId;
        this.description = description;
        this.status = Status.TO_DO;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    //Update Status
    public void markInProgress() {
        this.status = Status.IN_PROGRESS;
        this.updatedAt = LocalDateTime.now();
    }

    public void markDone() {
        this.status = Status.DONE;
        this.updatedAt = LocalDateTime.now();
    }

    public void updateDescription(String description) {
        this.description = description;
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return
                "id: " + id +
                ", description: " + description.strip() +
                ", status: " + status.toString() +
                ", createdAt: " + createdAt.format(formatter) +
                ", updatedAt: " + updatedAt.format(formatter);
    }
}
