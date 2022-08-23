package WordReader;
import java.io.*;
import java.util.ArrayList;

public class WordReader{
    public String path;

    public WordReader(String path) throws IOException {
        this.path = path;
    }

    private LineNumberReader getLineNumberReader() throws FileNotFoundException, UnsupportedEncodingException {
        LineNumberReader lnr =
                new LineNumberReader
                        (
                new InputStreamReader(
                new FileInputStream(path), "UTF-8"));
        return lnr;
    }


    public ArrayList<String> readAllWords() throws IOException {
        LineNumberReader lnr = getLineNumberReader();

        String line;
        ArrayList<String> arr = new ArrayList<>();
        while ((line = lnr.readLine()) != null) {
            arr.add(line);
        }
        System.out.print(arr);
        return arr;
    }


    //nullpointerexception alıyorum
    public ArrayList<String> readWords(int lineNumber) throws IOException {
        LineNumberReader lnr = getLineNumberReader();

        String line;
        int counter = 0;


        ArrayList<String> arr = new ArrayList<>();
        while ((line = lnr.readLine()) != null) {
            if (lnr.getLineNumber() == lineNumber) {
                arr.add(line);

            }
            counter++;
        }
        if (lineNumber > counter || lineNumber < 1) {
            System.out.println("Aradığınız satır bu dosyada mevcut değildir");
        } else {
            System.out.println(arr);
        }
        return arr;
    }
}











