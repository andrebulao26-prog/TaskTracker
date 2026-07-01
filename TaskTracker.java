
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
                   System.out.println("java TaskTracker add \"Task Description\"");
               }
               break;
           case "delete":
               if (Args.length == 2) {
                   try {
                       taskHandler.removeTask(Integer.parseInt(Args[1]));
                   } catch (NumberFormatException e) {
                       System.out.println("java TaskTracker delete <Task Id>");
                   }
               } else {
                   System.out.println("java TaskTracker delete <Task Id>");
               }
               break;
           case "update":
               if (Args.length == 3) {
                   try {
                       taskHandler.update(Integer.parseInt(Args[1]),Args[2]);
                   } catch (NumberFormatException e) {
                       System.out.println("java TaskTracker update <Task Id> \"New Description\"");
                   }
               } else {
                   System.out.println("java TaskTracker update <Task Id> \"New Description\"");
               }
               break;
           case "mark-in-progress":
               if (Args.length == 2) {
                   try {
                       taskHandler.status(Integer.parseInt(Args[1]),"in-progress");
                   } catch (NumberFormatException e) {
                       System.out.println("java TaskTracker mark-in-progress <Task Id>");
                   }
               } else {
                   System.out.println("java TaskTracker mark-in-progress <Task Id>");
               }
               break;
           case "mark-done":
               if (Args.length == 2) {
                   try {
                       taskHandler.status(Integer.parseInt(Args[1]),"done");
                   } catch (NumberFormatException e) {
                       System.out.println("java TaskTracker mark-done <Task Id>");
                   }
               } else {
                   System.out.println("java TaskTracker mark-done <Task Id>");
               }
               break;
           case "list":
               if (Args.length == 2) {
                   taskHandler.List(Args[1].toLowerCase());
               } else {
                   taskHandler.List("All");
               }
               break;
           default:
               System.out.println("Not a valid command!");
               break;
       }
    }

}