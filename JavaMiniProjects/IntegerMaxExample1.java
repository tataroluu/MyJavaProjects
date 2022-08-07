package ExamplesBilgeAdam;
import java.util.Scanner;
public class IntegerMaxExample1 {

         public static void main(String[] args) {
             System.out.println("Enter number: ");
            Scanner kl= new Scanner(System.in);
            int num1 = kl.nextInt();
            int num2 = kl.nextInt();

            //Print the larger number between a and b
            System.out.println("Large value of Math.max(" + num1 + "," + num2 + ") = " + Math.max(num1, num2));
        }
    }
