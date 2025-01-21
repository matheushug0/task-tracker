public class Main {
    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager();

        switch (args[0]){
            case "add":
                taskManager.addTask(args[1]);
                break;
            case "update":
                System.out.println(args[0] + args[1] + args[2]);
                //taskManager.updateTask(Integer.parseInt(args[1]), args[2]);
                break;
            case "delete":
                System.out.println("Delete Task: " + args[1]);
                break;
            case "list":
                System.out.println("List Task: " + args[1]);
                break;
            default:
                System.out.println("Unknown command: " + args[0]);
        }
        taskManager.saveTasks();
    }
}