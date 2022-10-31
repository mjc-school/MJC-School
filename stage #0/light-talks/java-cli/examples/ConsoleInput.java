import java.util.Scanner;

public class ConsoleInput {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
	System.out.println("Enter the first number : ");
        int number1 = sc.nextInt();

        System.out.println("Enter the second number : ");
        int number2 = sc.nextInt();
        System.out.println("The sum = " + (number1 + number2));
    }
}
   