import java.util.ArrayList;
import java.util.List;

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
        if(tasks.contains(task)) {
            System.out.println("Task already exists");
        }else {
            tasks.add(task);
            System.out.println("Task added successfully! (ID: " + task.getId() + ")");
        }
    }
}