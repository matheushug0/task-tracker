import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TaskStorage {
    public static final String FILE_NAME = "tasks.json";

    public static void saveTasks(List<Task> tasks) {
        List<String> lines = new ArrayList<>();
        lines.add("[");
        for(int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            lines.add(t.toJson());
            if(i < tasks.size() - 1) {
                lines.add(",");
            }
        }
        lines.add("]");

        try {
            Files.write(Paths.get(FILE_NAME), lines);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static List<Task> loadTasks() {
        Path path = Paths.get(FILE_NAME);
        List<Task> tasks = new ArrayList<>();

        if(Files.exists(path)) {
            try{
                List<String> lines = Files.readAllLines(path);
                if(lines.size() > 2) {
                    List<String> taskLines = lines.subList(1, lines.size() - 1);
                    for(String line: taskLines){
                        line = line.trim();
                        if(line.endsWith(",")) {
                            line = line.substring(0, line.length() - 1);
                        }
                        tasks.add(Task.fromJson(line));
                    }
                }
            } catch (IOException e) {
                System.out.println("Erro ao carregar as Tasks: " + e.getMessage());
            }
        }
        return tasks;
    }
}
