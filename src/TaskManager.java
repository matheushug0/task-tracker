import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Task> tasks;

    public TaskManager() {
        this.tasks = loadTasks();
    }

    public List<Task> loadTasks() {
        return new ArrayList<>();
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
}