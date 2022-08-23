package WordReader;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class deneme {
    public static void main(String[] args) throws IOException {


        File file = new File( "C:\\dosya\\dosya.txt" );
        FileReader  fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        LineNumberReader lnr = new LineNumberReader(fr);

        String line ;

        ArrayList<String> arr = new ArrayList<>();
        while ((line = lnr.readLine()) != null )
        {
             if(lnr.getLineNumber()==2)
            {
                arr.add(line);
            }
        }
         System.out.println(arr);


    }
}

