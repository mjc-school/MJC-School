public class ArgsExample {
    public static void main(String args[]) {
        System.out.println("The args count = " + args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "] = " + args[i]);
        }
    }
}