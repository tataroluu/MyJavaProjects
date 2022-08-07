package ExamplesBilgeAdam;

public class UniqCharCounter {
    public static void main(String[] args) {
        String text= "ABSDAXAAA AAA";
        int count = 0;
        char[] chararray =new char[text.length()];
         for (int i=0;i<text.length();i++){


            for (int j = 0; j < text.length() ; j++) {
                if(text.charAt(i)==text.charAt(j)){
                   count++;

                }
            }
            if  (count>0 && count<2){
                      chararray[i] += text.charAt(i);
                System.out.print(chararray[i]);

                }
            count=0;


        }







    }
}
