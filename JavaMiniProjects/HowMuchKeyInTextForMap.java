package ExamplesBilgeAdam;

 import java.util.*;

public class HowMuchKeyInTextForMap {
    public static void main(String[] args) {

        String  text = "AAAABBBBBBB";
        LinkedHashMap<Character, Integer> countMap =    new LinkedHashMap<Character, Integer>();
        StringBuilder sb=new StringBuilder();
        StringBuilder AA=new StringBuilder();
        for (char tempIndex : text.toCharArray()) {
            if (countMap.containsKey(tempIndex)) {
                countMap.put(tempIndex, countMap.get(tempIndex) + 1);
            } else {
                countMap.put(tempIndex,1);
            }
        }

        for (Character key :countMap.keySet()) {
            sb.append(key +countMap.get(key).toString());

        }
        System.out.println(sb);


    }
}
