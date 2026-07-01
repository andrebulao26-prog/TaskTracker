import java.time.LocalDateTime;

public class Task {
    public Integer id = 0;
    public String description = "";
    public String status = "";
    public String createdAt = "";
    public String updatedAt = "";
    public static Integer LastID = 0;

    public Task(Integer id, String description, String status, String createdAt, String updatedAt) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    void update(String description) {
        this.description = description;
        updated();
    }
    void updateStatus(String status) {
        this.status = status;
        updated();
    }
    void updated(){
        LocalDateTime dateTime = LocalDateTime.now();
        this.updatedAt = String.valueOf(dateTime);
    }
    void printTask(){

        System.out.println("(#" + this.id + ") " + this.description + " - " + this.status);

    }

}
