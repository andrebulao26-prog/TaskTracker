import javax.xml.namespace.QName;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;

public class TaskHandler {

    Path filePath = Paths.get("tasks.json");

    void addTask(String description) {

        ArrayList<Task> tasks = getTasks();

        description = description.replace("\"","");
        LocalDateTime dateTime = LocalDateTime.now();
        Integer NewID = getLastID(tasks)+1;

        Task newTask = new Task(NewID,description,"todo",String.valueOf(dateTime),String.valueOf(dateTime));
        tasks.add(newTask);

        System.out.println("Task added successfully (ID: "+NewID + ")");

        saveToJson(tasks);

    }

    void removeTask (Integer id) {

        ArrayList<Task> tasks = getTasks();
        Task task = getTask(id,tasks);

        if (task == null) {
            System.out.println("Task of id " + id + " doesnt exist!");
            return;
        }

        tasks.remove(task);
        saveToJson(tasks);

    }

    void update (Integer id, String description) {

        description = description.replace("\"","");
        ArrayList<Task> tasks = getTasks();
        Task task = getTask(id,tasks);

        if (task == null) {
            System.out.println("Task of id " + id + " doesnt exist!");
            return;
        }

        task.update(description);

        saveToJson(tasks);

    }

    void status (Integer id, String status) {

        status = status.replace("\"","");
        ArrayList<Task> tasks = getTasks();
        Task task = getTask(id,tasks);

        if (task == null) {
            System.out.println("Task of id " + id + " doesnt exist!");
            return;
        }

        task.updateStatus(status);

        saveToJson(tasks);

    }

    void List (String status) {

        if (!status.equals("todo") && !status.equals("done") && !status.equals("in-progress") && !status.equals("All")) {
            System.out.println(status + " is not a valid status");
            return;
        }

        ArrayList<Task> tasks = getTasks();

        System.out.println("Tasks:");
        for (Task task : tasks) {
            if (task.status.equals(status) || status == "All") {
                task.printTask();
            }
        }

    }

    Task getTask(Integer id,ArrayList<Task> tasks) {
        for (Task task : tasks) {
            if (task.id == id) {
                return task;
            }
        }
        return null;
    }

    Integer getLastID (ArrayList<Task> tasks){

        Integer Highest = 0;
        for (Task task : tasks) {
            if (task.id > Highest) {
                Highest = task.id;
            }
        }

        return Highest;
    }

    ArrayList<Task> getTasks() {
        try {

            //Get raw string to edit it

            String rawString = Files.readString(filePath);

            ArrayList<Task> tasks = new ArrayList<>();
            String[] split1 = rawString.replace("\n","").replace("\"","").replace("[","").replace("]","").replace("{","").replace("}","").replace(", ",":").replace(": ",":").split(",");

            //Split the tasks

            for (String string : split1){

                //System.out.println("---");
                //System.out.println(string);

                //Split the task data by ,

                String[] data = string.split(":");

                Integer id = Integer.parseInt(String.valueOf(data[1]));

                if (id == 0) {
                    continue;
                }

                String description = data[3];
                String status = data[5];
                String createdAt = data[7];
                String updatedAt = data[9];

                Task task = new Task(id,description,status,createdAt,updatedAt);

                tasks.add(task);

            }

            return tasks;

        } catch (IOException e) {
            System.out.println("Error getting task");
            return new ArrayList<Task>();
        }
    }

    void saveToJson(ArrayList<Task> tasks) {

        String rawtext = "[\n";

        Integer ith = 1;
        for (Task task : tasks) {

            String data = String.format("{\"id\": %d, \"description\": \"%s\", \"status\": \"%s\", \"createdAt\": \"%s\", \"updatedAt\": \"%s\"}", task.id, task.description, task.status, task.createdAt, task.updatedAt);
            //String data = "{\"id\": \"" + task.id + "\", " + "\"description\": \"" + task.description + "\", " + "\"status\": \"" + task.status + "\", " + "\"createdAt\": \"" + task.createdAt + "\", " + "\"updatedAt\": \"" + task.updatedAt;

            if (ith < tasks.size()) {
                data = data + ",";
            }

            data = data + "\n";

            rawtext = rawtext + data;
            ith++;

        }

        rawtext = rawtext + "]";

        //System.out.println(rawtext);

        try {
            Files.write(filePath, rawtext.getBytes());
            //System.out.println("Successfuly saved");
        } catch (IOException e) {
            System.out.println("failed to write");
        }

    }

}