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
        StringBuilder builder = new StringBuilder();
        builder.append("[\n");
        for(int i = 0; i < tasks.size(); i++) {
            builder.append(tasks.get(i).toJson());
            if(i < tasks.size() - 1) {
                builder.append(",\n");
            }
        }
        builder.append("\n]");

        try {
            Files.writeString(Paths.get(FILE_NAME), builder.toString());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static List<Task> loadTasks() {
        Path path = Path.of(FILE_NAME);
        List<Task> tasks = new ArrayList<>();

        if(!Files.exists(path)) {
            return tasks;
        }
            try{
                String json = Files.readString(path);
                String[] lines = json
                        .replace("[", "")
                        .replace("]", "")
                        .split("},");
                for(String line : lines) {
                    System.out.println(line);
                    if(!line.endsWith("}")) {
                        line = line + "}";
                        tasks.add(Task.fromJson(line));
                    }else {
                        tasks.add(Task.fromJson(json));
                    }
                }
            } catch (IOException e) {
                System.out.println("Erro ao carregar as Tasks: " + e.getMessage());
            }
        return tasks;
    }
}
