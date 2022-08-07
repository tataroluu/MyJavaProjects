package ExamplesBilgeAdam;

import java.util.HashMap;
import java.util.Scanner;

public class HowMuchKeyInTextForMapToList {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.print ("Please enter a text:");
        String textInput =scanner.next();
        HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();
        for (char tempIndex : textInput.toCharArray()) {
            if (countMap.containsKey(tempIndex)) {
                countMap.put(tempIndex, countMap.get(tempIndex) + 1);
            } else {
                countMap.put(tempIndex,1);
            }

        }

        for (HashMap.Entry<Character, Integer> countMapIndex: countMap.entrySet()) {

            System.out.print(countMapIndex);

        }
    }
}
