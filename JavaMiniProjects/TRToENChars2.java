package ExamplesBilgeAdam;
import java.util.Scanner;
public class TRToENChars2 {


    public static void main(String[] args) {


        Scanner scannerInput = new Scanner(System.in);
        System.out.print("Enter name: ");
        String scannerInputName = scannerInput.next();

        if (scannerInputName != null && scannerInputName.matches("^[\\p{L}\\p{N}ın\\s]*$")) {
            System.out.println(scannerInputName
                    .replace("ğ","g")
                    .replace("Ğ","G")
                    .replace("ç","c")
                    .replace("Ç","C")
                    .replace("ş","s")
                    .replace("Ş","S")
                    .replace("ü","u")
                    .replace("Ü","U")
                    .replace("ö","o")
                    .replace("Ö","O")
                    .replace("ı","i")
                    .replace("İ","I")
            );
        }
        else if (scannerInputName.matches("^[\\p{L}ın\\s]*$")){
            System.out.println("Please enter a valid word! Yapmış olduğunuz giriş: " + scannerInputName );
        }

    }

}
