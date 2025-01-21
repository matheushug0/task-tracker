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
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

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

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
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

    public String toJson() {
        return "{\"id\":\"" + id + "\", \"description\":\"" + description.strip() + "\", \"status\":\"" + status.toString() +
                "\", \"createdAt\":\"" + createdAt.format(formatter) + "\", \"updatedAt\":\"" + updatedAt.format(formatter) + "\"}";
    }

    public static Task fromJson(String json) {
        json = json.replaceAll("[{}\"]", "");
        String[] parts = json.split(",");

        String id = parts[0].split(":")[1].strip();
        String description = parts[1].split(":")[1].strip();
        Status status = Status.valueOf(parts[2].split(":")[1].strip());
        String createdAt = parts[3].split("[a-z]:")[1].strip();
        String updatedAt = parts[4].split("[a-z]:")[1].strip();

        Task task = new Task(description);
        task.setId(Integer.parseInt(id));
        task.setStatus(status);
        task.setCreatedAt(LocalDateTime.parse(createdAt, formatter));
        task.setUpdatedAt(LocalDateTime.parse(updatedAt, formatter));

        if(Integer.parseInt(id) > lastTaskId){
            lastTaskId = Integer.parseInt(id);
        }

        return task;
    }
}
