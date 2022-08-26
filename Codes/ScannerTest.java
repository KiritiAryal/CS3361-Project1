/**
 *
 * @author Bibek Dhunagana, Kiriti Aryal, Arogya Bhatta
 * @version 1.0
 * @since March 25, 2022
 * This file is testing Scanner class and outputs the result in the standard console
 */

 //importing all the required libraries
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ScannerTest {
    /**
     * @param args the command line arguments
     * @return void
     * This is the implementor function of the program
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
  
        FileReader fr = new FileReader("input.txt");            //create reference to the file
        BufferedReader filePointer = new BufferedReader(fr);    //reading content using buffered reader
        String fileInputString = "";                            //creating empty string to track the character
        Scanner scanner = new Scanner();                        //creating object of custom built scanner

        //loop only if the file is identified
        if(filePointer != null){
            //variable to track character pointer
            int i = 1;     
            
            //loops until the EOF and displaying the result
            while ((fileInputString = filePointer.readLine())!= null){
               String[] data = fileInputString.split(" ");           //splits file input between spaces and stores in string array
               System.out.println();
               System.out.println("Displaying valid identifiers with custom built Scanner");
               System.out.println("------------------------------------------------------");
               System.out.println("Line number: "+i);                //displays the current line 
               scanner.scan(data);
               System.out.println("---------------------------------------");
               i++;
            }
            
            System.out.println("All tokens from the given file have been accounted!");
            System.out.println();
            System.out.println("----------------- END ------------------------------");
            filePointer.close();
        }    
    }
}

