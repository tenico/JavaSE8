package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileScanInteractive {

    public int countTokens(String file, String search) throws IOException {
        int instanceCount = 0;
        try (FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                Scanner s = new Scanner(br)) {
            s.useDelimiter("\\W");
            while (s.hasNext()) {
                if (search.equalsIgnoreCase(s.next().trim())) {
                    instanceCount++;
                }
            }
        } // try-with-resources will close the connections
        return instanceCount;
    }

    public static void main(String[] args) {
        
        //3. Check the number of arguments passed
        if (args.length < 1) {
            System.out.println("There is less than one argument passed");
            System.exit(-1);
        }
        //4. Save the argument as a string
        String file = args[0];

        //5. Create an instance of ScanFileInteractive class
        FileScanInteractive scan = new FileScanInteractive();
        //6. a) try-with-resources a BufferedReader(using System.in)
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            // Wrap the System.in InputStream with a BufferedReader to read
            // each line from the keyboard.
            String search = "";
            System.out.println("Searching through the file: " + file);
            //c) use a while loop
            while (true) {
                System.out.print("Enter the search string or q to exit: ");
                search = in.readLine().trim();
                //c) search for q pressed
                if (search.equalsIgnoreCase("q")) {
                    break;
                }
                //d) call countTokens if not terminate character
                int count = scan.countTokens(file, search);
                //e) print string of count
                System.out.println("The word:" + search + " appears : "
                        + count + " times");
            }
            //b) use Catch with IOEXception
        } catch (IOException e) { 
            System.out.println("Exception: " + e);
            System.exit(-1);
        }
    }
}