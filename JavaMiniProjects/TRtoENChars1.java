package ExamplesBilgeAdam;

import java.util.Scanner;

public class TRtoENChars1 {

    public static void main(String[] args) {

        String scannerToString = getString();
        System.out.println("State of the name: " + scannerToString);

    }

    //Get String
    private static String getString() {
        String scannerToString = scanner();


        char[] harfArray = new char[]{'ğ', 'Ğ', 'ç', 'Ç', 'ş', 'Ş', 'ü', 'Ü', 'ö', 'Ö', 'ı', 'İ'};
        char[] numberArray = new char[]{'g', 'G', 'c', 'C', 's', 'S', 'u', 'U', 'o', 'O', 'i', 'I'};
        for (int counter = 0; counter < harfArray.length; counter++) {
            scannerToString = scannerToString.replaceAll(new String(new char[]{harfArray[counter]}), new String(new char[]{numberArray[counter]}));
        }
        return scannerToString;
    }

    //scanner
    public static String scanner() {
        Scanner scannerInput = new Scanner(System.in);
        System.out.print("Enter the name: ");
        String scannerInputName = scannerInput.next();
        return scannerInputName;
    }

}

