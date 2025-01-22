public class Tasker {
    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager();

        if (args.length < 1) {
            System.out.println("Please enter: Tasker [command] <description>");
            System.out.println("Example: Tasker add \"Buy something\"");
        }

        switch (args[0]) {
            case "add":
                if (args.length < 2) {
                    System.out.println("Please enter: Tasker add \"Task Description\"");
                    return;
                }
                taskManager.addTask(args[1]);
                break;
            case "update":
                if (args.length < 3) {
                    System.out.println("Please enter: Tasker update ID \"Task Description\"");
                    return;
                }
                taskManager.updateTask(Integer.parseInt(args[1]), args[2]);
                break;
            case "delete":
                if (args.length < 2) {
                    System.out.println("Please enter: Tasker delete ID");
                    return;
                }
                taskManager.deleteTask(Integer.parseInt(args[1]));
                break;
            case "mark-in-progress":
                if (args.length < 2) {
                    System.out.println("Please enter: Tasker mark-in-progress ID");
                    return;
                }
                taskManager.markTask(Integer.parseInt(args[1]), Status.IN_PROGRESS);
                break;
            case "mark-done":
                if (args.length < 2) {
                    System.out.println("Please enter: Tasker mark-done ID");
                    return;
                }
                taskManager.markTask(Integer.parseInt(args[1]), Status.DONE);
                break;
            case "mark-to-do":
                if (args.length < 2) {
                    System.out.println("Please enter: Tasker mark-to-do ID");
                    return;
                }
                taskManager.markTask(Integer.parseInt(args[1]), Status.TO_DO);
                break;
            case "list":
                if (args.length < 2) {
                    taskManager.listTasks("all");
                } else if (args[1].equals("todo")) {
                    taskManager.listTasks(Status.TO_DO.toString());
                } else if (args[1].equals("done")) {
                    taskManager.listTasks(Status.DONE.toString());
                } else if (args[1].equals("in-progress")) {
                    taskManager.listTasks(Status.IN_PROGRESS.toString());
                } else {
                    System.out.println("Please enter a valid Status(e.g, done, todo, in-progress)");
                }
                break;
            case "clear":
                if (args.length < 2) {
                    taskManager.clearTasks();
                }
                break;
            case "help":
                System.out.println("-- Task Tracker: How to Use --\n" +
                        "java Tasker [command] <description>\n" +
                        "Example: Tasker add \"Buy something\"" +
                        "\nCommands:" +
                        "\n* add <description> - Add a task to the list of tasks>" +
                        "\n* update <id> <description - Update a Task description by ID" +
                        "\n* mark-in-progress <id> - Mark a Task status for In Progress" +
                        "\n* mark-done <id> - Mark a Task status for Done" +
                        "\n* mark-to-do <id> - Mark a Task status for To Do" +
                        "\n* list - List all Tasks" +
                        "\n* list done - List Tasks with Done Status" +
                        "\n* list todo - List Tasks with To Do Status" +
                        "\n* list in-progress - List Tasks with In Progress Status" +
                        "\n* clear - Clear all tasks");
            default:
                System.out.println("Unknown command: " + args[0]);
        }
        taskManager.saveTasks();
    }
}