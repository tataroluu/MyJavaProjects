package ExamplesBilgeAdam;
public class HowMuchKeyInText {
    public static void main(String[] args) {

        String text = "human is the human";

        char[] charArray = new char[text.length()];
        int[] counter = new int[256];

        for (int i = 0; i < text.length(); i++) {
            counter[text.charAt(i)]++;
        }
        for (int j = 0; j < text.length(); j++) {

            charArray[j] = text.charAt(j);
            int count = 0;
            for (int k = 0; k <= j; k++) {

                if (text.charAt(j) == charArray[k])
                    count++;
            }

            if (count <2) {
                System.out.print(text.charAt(j) + "" + counter[text.charAt(j)]);
            }
        }

    }
}
