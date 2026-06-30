import javax.xml.namespace.QName;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TaskHandler {

    Path filePath = Paths.get("tasks.json");

    void addTask(String description) {

        Task task = new Task(description);

        saveTask(task);

    }
    void saveTask(Task task) {

        try {

            //Get raw string to edit it

            Integer id = task.id;

            String rawString = Files.readString(filePath);



        } catch (IOException e) {
            System.out.println("Error saving task");
        }

    }

}