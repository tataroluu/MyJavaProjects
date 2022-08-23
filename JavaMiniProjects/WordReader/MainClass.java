package WordReader;


import java.io.IOException;
import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) throws IOException {


        WordReader reader = new WordReader("C:\\dosya\\dosya.txt");
        ArrayList<String> words = reader.readWords(11);
        ArrayList<String> allWords = reader.readAllWords();
    }
}
