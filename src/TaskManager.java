import java.util.List;
import java.util.Scanner;

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
        tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .ifPresentOrElse(task -> {
                    task.setDescription(description);
                            System.out.println("Task updated successfully! (ID: " + task.getId() + ")");
                    },
                        () -> System.out.println("Task not found!"));

    }

    //Delete Task
    public void deleteTask(int id) {
        if(tasks.removeIf(task -> task.getId() == id)){
            System.out.println("Task deleted successfully! (ID: " + id + ")");
        }else {
            System.out.println("Task not found! (ID: " + id + ")");
        }
    }

    //Mark Task
    public void markTask(int id, Status status) {
        tasks.stream().filter(task -> task.getId() == id).findFirst().ifPresentOrElse(task -> {
            if(task.getStatus() == status) {
                System.out.println("Task already marked " + status.getStatus() + "  (ID: " + id + ")");
                return;
            }
            switch (status){
                case IN_PROGRESS:
                    task.markInProgress();
                    break;
                case DONE:
                    task.markDone();
                    break;
                case TO_DO:
                    task.markToDo();
            }
            System.out.println("Task marked successfully! (ID: " + id + ")");
        }, () -> System.out.println("Task not found!"));
    }

    //List
    public void listTasks(String status) {
        int count = 0;

        if(status.equals("all")){
            for(Task task : tasks){
                System.out.println(task.toString());
                count++;
            }if (count < 1) {
                System.out.println("No tasks found!");
            }
            return;
        }

        for (Task task : tasks) {
            if (task.getStatus() == Status.valueOf(status)) {
                System.out.println(task.toString());
                count++;
            }
        }
        if(count < 1){
            System.out.println("No tasks found!");
        }
    }

    //Clear
    public void clearTasks() {
        Scanner scanner = new Scanner(System.in);

        if(tasks.isEmpty()){
            System.out.println("No tasks found!");
            return;
        }

        System.out.print("Are you sure? [Y/n]: ");
        String answer = scanner.nextLine();
        System.out.println(answer);

        answer = answer.toLowerCase();
        if (answer.startsWith("y")) {
            tasks.clear();
            System.out.println("All Tasks cleared!");
        }else {
            System.out.println("Clear Tasks cancelled!");
        }
    }
}