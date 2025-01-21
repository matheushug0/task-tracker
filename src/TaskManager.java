import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class TaskManager {

    private List<Task> tasks;

    public TaskManager() {
        this.tasks = loadTasks();
    }

    public List<Task> loadTasks() {
        return TaskStorage.loadTasks();
    }

    public void saveTasks() {
        TaskStorage.saveTasks(tasks);
    }

    //Add Task
    public void addTask(String description) {
        Task task = new Task(description);
            tasks.add(task);
            System.out.println("Task added successfully! (ID: " + task.getId() + ")");
    }

    //Update Task
    public void updateTask(int id, String description) {
        //AtomicBoolean success = new AtomicBoolean(false);
        tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .ifPresent(task -> {task.setDescription(description);});
    }
}