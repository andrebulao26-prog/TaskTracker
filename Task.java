public class Task {
    public Integer id = 0;
    public String description = "";
    public String status = "";
    public String createdAt = "";
    public String updatedAt = "";
    static Integer lastId = 0;

    public Task(String description) {
        lastId++;
        this.id = lastId;
        this.description = description;
        this.status = "not done";
    }

}
