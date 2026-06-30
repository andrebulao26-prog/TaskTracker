
public class TaskTracker {

    public static void main(String[] Args) {

        if (Args.length < 1) {
            System.out.println("java TaskTracker <Command>");
            return;
        }

        TaskHandler taskHandler = new TaskHandler();

        String Command = Args[0];

       switch (Command.toLowerCase()) {

           case "add":
               if (Args.length == 2) {
                   taskHandler.addTask(Args[1]);
               } else {
                   System.out.println("java TaskTracker add <Task Name>");
               }

               break;
           case "delete":
               System.out.println("deleted");
               break;
           case "update":
               System.out.println("updated");
               break;
           case "mark-in-progress":
               System.out.println("in progress");
               break;
           case "mark-done":
               System.out.println("mark-done");
               break;
           case "list":
               System.out.println("list");
               break;
           default:
               System.out.println("POOP!");
               break;
       }
    }

}