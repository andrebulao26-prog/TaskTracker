public class TaskTracker {

    public static void main(String[] Args) {

        if (Args.length < 1) {
            System.out.println("java TaskTracker <Command>");
            return;
        }

        String Command = Args[0];

        System.out.println(Command);

    }

}