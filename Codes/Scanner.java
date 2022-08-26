/**
 *
 * @author Bibek Dhunagana, Kiriti Aryal, Arogya Bhatta
 * @version 1.0
 * @since March 25, 2022
 * This class is implementation of the Scanner. The primary function of a scanner is to read in characters from a source file and group them into tokens.
 * Input file: input.txt
 * This class reads all the characters from input.txt and outputs all the tokens in standard output.
 */

//inputing all the required libraries
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;


//implementation of Scanner class
public class Scanner {
    int index = 0;
    char previousChar;
    char nextChar;
    String getfileData = "";
    String token = "";

    //empty constuctor
    public Scanner() {

    }
    //scan function of the program
    public void scan(String[] data) {

        // this function finds valid single token
        findValidToken(data);

        // this function finds identifiers
        findId(data);

        // this function finds reserved keyword
        findKeyword(data);

        // this function checks for the assignment
        findAssignment(data);

        // this function checks if there are any comments
        findComment(data);

        // this checks for floating point numbers
        findFloatingPointNumber(data);

        // this function checks for digits
        findDigit(data);

    }
    /**
     * 
     * @param String[] 
     * @return void
     * This function finds valid single token
     */
    public void findValidToken(String[] data) { /******  ******/
        int i, j;
        for (i = 0; i < data.length; i++) {
            for (j = 0; j < data[i].length(); j++) {
                if ((previousChar = data[i].charAt(j)) == '/') {
                    j++;
                    if (((nextChar) = data[i].charAt(j)) == '/') {
                        i = data.length;
                        break;
                    } else if (((nextChar) = data[i].charAt(j)) == '*') {

                        while ((data[i].charAt(data[i].length() - 1) != '/') || i == data.length) {
                            i++;
                        }
                        ;
                        if (data[i].length() > 1 && i < data.length && data[i].charAt(data[i].length() - 2) == '*') {
                            break;
                        }
                    }

                }

                if ((previousChar = data[i].charAt(j)) == ',' || (previousChar = data[i].charAt(j)) == '+'
                        || (previousChar = data[i].charAt(j)) == '*' || (previousChar = data[i].charAt(j)) == '('
                        || (previousChar = data[i].charAt(j)) == ')'
                        || (previousChar = data[i].charAt(j)) == '-' || (previousChar = data[i].charAt(j)) == '?'
                        || (previousChar = data[i].charAt(j)) == ';' || (previousChar = data[i].charAt(j)) == '<'
                        || (previousChar = data[i].charAt(j)) == '>' || (previousChar = data[i].charAt(j)) == '{'
                        || (previousChar = data[i].charAt(j)) == '}' || (previousChar = data[i].charAt(j)) == '['
                        || (previousChar = data[i].charAt(j)) == ']') {
                    System.out.print(previousChar + "   : single token");
                    System.out.println();

                    index++;
                }
            }
        }

    }

    /**
     * 
     * @param String[] 
     * @return void
     * This function finds floating point numbers
     */
    public void findFloatingPointNumber(String[] data) 
    {
        int i, j;
        for (i = 0; i < data.length; i++) {
            for (j = 0; j < data[i].length(); j++) {
                if ((previousChar = data[i].charAt(j)) == '/') {
                    j++;
                    if (((nextChar) = data[i].charAt(j)) == '/') {
                        i = data.length;
                        break;
                    } else if (((nextChar) = data[i].charAt(j)) == '*') {

                        while ((data[i].charAt(data[i].length() - 1) != '/') || i == data.length) {
                            i++;
                        }
                        ;
                        if (data[i].length() > 1 && i < data.length && data[i].charAt(data[i].length() - 2) == '*') {
                            break;
                        }
                    }

                }

                int x;
                x = 0;
                previousChar = data[i].charAt(x);
                if ((previousChar == '0' || previousChar == '1' || previousChar == '2' || previousChar == '3' || (previousChar) == '4'
                        || (previousChar) == '5' || (previousChar) == '6'
                        || (previousChar) == '7' || (previousChar) == '8' || (previousChar) == '9') && j == x) {
                    if (data[i].length() == 1) {
                        System.out.print(data[i] + "     : digit");
                        System.out.println();
                        continue;
                    }
                    if (!data[i].matches("\\d[A-Za-z]*")) {
                        x++;
                        if (x < data[i].length()) {
                            nextChar = data[i].charAt(x);
                            do {
                                nextChar = data[i].charAt(x);
                                x++;
                            } while (nextChar != '.' && x < data[i].length());
                            do {
                                x++;
                                x++;
                                break;
                            } while (nextChar == '.');
                        }

                        System.out.println(data[i].substring(0, x) + "      has a decimal point");

                    } else
                        System.out.println(data[i] + "      Error: Invalid token!");

                }
            }
        }
    }

    /**
     * 
     * @param String[] 
     * @return void
     * This function checks for identifiers
     */
    public void findId(String[] data) 
    {
        int i, j;
        for (i = 0; i < data.length; i++) {
            for (j = 0; j < data[i].length(); j++) {

                if ((previousChar = data[i].charAt(j)) == '/') {
                    j++;
                    if (((nextChar) = data[i].charAt(j)) == '/') {
                        i = data.length;
                        break;
                    } else if (((nextChar) = data[i].charAt(j)) == '*') {

                        while ((data[i].charAt(data[i].length() - 1) != '/') || i == data.length) {
                            i++;
                        }
                        if (data[i].length() > 1 && i < data.length && data[i].charAt(data[i].length() - 2) == '*') {
                            break;
                        }
                    }

                }

                previousChar = Character.toLowerCase(data[i].charAt(j));
                while ((previousChar == 'a' || previousChar == 'b' || previousChar == 'c' || previousChar == 'd' || previousChar == 'e'
                        || previousChar == 'f' || previousChar == 'g' || previousChar == 'h'
                        || previousChar == 'i' || previousChar == 'j' || previousChar == 'k' || previousChar == 'l' || previousChar == 'm'
                        || previousChar == 'n' || previousChar == 'o' || previousChar == 'p'
                        || previousChar == 'q' || previousChar == 'r' || previousChar == 's' || previousChar == 't' || previousChar == 'u'
                        || previousChar == 'v' || previousChar == 'w' || previousChar == 'x'
                        || previousChar == 'y' || previousChar == 'z') && j == 0) {
                    j++;

                    if (data[i].equals("read") || data[i].equals("write") || data[i].equals("int")
                            || data[i].equals("char") || data[i].equals("print")
                            || data[i].equals("long") || data[i].equals("for") || data[i].equals("if")
                            || data[i].equals("else") || data[i].equals("float") ||
                            data[i].equals("double") || data[i].equals("while") || data[i].equals("switch")
                            || data[i].equals("case") || data[i].equals("String")) {
                        continue;

                    }

                    else if (data[i].charAt(data[i].length() - 1) == ';'
                            || data[i].charAt(data[i].length() - 1) == ')') {

                        System.out.print(data[i].substring(0, data[i].length() - 1) + "         : id");
                        System.out.println();
                        System.out.print(data[i].charAt(data[i].length() - 1) + "      : single token");

                    }

                    else
                        System.out.print(data[i] + "       : id");
                    System.out.println();
                }
            }
        }

    }

    /**
     * 
     * @param String[] 
     * @return void
     * This function checks for reserved keywords
     */
    public void findKeyword(String[] data) { 
        int i, j;
        for (i = 0; i < data.length; i++) {
            for (j = 0; j < data[i].length(); j++) {

                if ((previousChar = data[i].charAt(j)) == '/') {
                    j++;
                    if (((nextChar) = data[i].charAt(j)) == '/') {
                        i = data.length;
                        break;
                    } else if (((nextChar) = data[i].charAt(j)) == '*') {

                        while ((data[i].charAt(data[i].length() - 1) != '/') || i == data.length) {
                            i++;
                        }
                        if (data[i].length() > 1 && i < data.length && data[i].charAt(data[i].length() - 2) == '*') {
                            break;
                        }
                    }

                }

                previousChar = Character.toLowerCase(data[i].charAt(j));
                while ((previousChar == 'a' || previousChar == 'b' || previousChar == 'c' || previousChar == 'd' || previousChar == 'e'
                        || previousChar == 'f' || previousChar == 'g' || previousChar == 'h'
                        || previousChar == 'i' || previousChar == 'j' || previousChar == 'k' || previousChar == 'l' || previousChar == 'm'
                        || previousChar == 'n' || previousChar == 'o' || previousChar == 'p'
                        || previousChar == 'q' || previousChar == 'r' || previousChar == 's' || previousChar == 't' || previousChar == 'u'
                        || previousChar == 'v' || previousChar == 'w' || previousChar == 'x'
                        || previousChar == 'y' || previousChar == 'z') && j == 0) {
                    j++;

                    //checking reserved keywords
                    if (data[i].equals("read") || data[i].equals("write") || data[i].equals("int")
                            || data[i].equals("char") || data[i].equals("print")
                            || data[i].equals("long") || data[i].equals("for") || data[i].equals("if")
                            || data[i].equals("else") || data[i].equals("float") ||
                            data[i].equals("double") || data[i].equals("while") || data[i].equals("switch")
                            || data[i].equals("case") || data[i].equals("String") ||  data[i].equals("struct") || data[i].equals("void"))  {
                        System.out.print(data[i] + "         : keyword.");
                        System.out.println();

                    }

                    else {
                        continue;
                    }
                }
            }
        }
    }

    /**
     * 
     * @param String[] 
     * @return void
     * This function checks for assingments
     */

    public void findAssignment(String[] data) 
    {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length(); j++) {
                if ((previousChar = data[i].charAt(j)) == '/') {
                    j++;
                    if (((nextChar) = data[i].charAt(j)) == '/') {
                        i = data.length;
                        break;
                    } else if (((nextChar) = data[i].charAt(j)) == '*') {

                        while ((data[i].charAt(data[i].length() - 1) != '/') || i == data.length) {
                            i++;
                        }
                        if (data[i].length() > 1 && i < data.length && data[i].charAt(data[i].length() - 2) == '*') {
                            break;
                        }
                    }

                }

                if ((previousChar = data[i].charAt(j)) == ':') {
                    index++;
                    if (data[i].length() > 1) {
                        if ((nextChar = data[i].charAt(j + 1)) == '=') {
                            index++;
                            System.out.println("\n" + previousChar + "" + nextChar + " i.e, Assign\n");
                        }
                    } else if (data[i].length() == 1) {
                        System.out.println(data[i] + "     : single token");
                    }
                }
            }
        }
    }

    /**
     * 
     * @param String[] 
     * @return void
     * This function checks for comments
     */
    public void findComment(String[] data) 
    {
        int i, j;
        for (i = 0; i < data.length; i++) {
            for (j = 0; j < data[i].length(); j++) {

                if ((previousChar = data[i].charAt(j)) == '/') {

                    j++;
                    if (((nextChar) = data[i].charAt(j)) == '/') {
                        i = data.length;
                        System.out.println("Scanner found comments. Everything after // is ignored");
                        break;
                    } else if (((nextChar) = data[i].charAt(j)) == '*') {

                        while ((data[i].charAt(data[i].length() - 1) != '/') || i == data.length) {
                            i++;
                        }
                        if (data[i].length() > 1 && i < data.length && data[i].charAt(data[i].length() - 2) == '*') {
                            System.out.println("This line is a comment.");
                            break;
                        }
                    }

                }

            }
        }
    }

    /**
     * 
     * @param String[] 
     * @return void
     * This function checks for digits
     */
    public void findDigit(String[] data) 
    {
        int i, j;
        for (i = 0; i < data.length; i++) {
            for (j = 0; j < data[i].length(); j++) {

                if ((previousChar = data[i].charAt(j)) == '/') {
                    j++;
                    if (((nextChar) = data[i].charAt(j)) == '/') {
                        i = data.length;
                        break;
                    } else if (((nextChar) = data[i].charAt(j)) == '*') {

                        while ((data[i].charAt(data[i].length() - 1) != '/') || i == data.length) {
                            i++;
                        }
                        ;
                        if (data[i].length() > 1 && i < data.length && data[i].charAt(data[i].length() - 2) == '*') {
                            break;
                        }
                    }

                }

                if ((previousChar = data[i].charAt(j)) == '.' && j == 0) {

                    index++;
                    int x;
                    x = 1;

                    nextChar = data[i].charAt(x);
                    do {

                        nextChar = data[i].charAt(x);
                        x++;
                    } while ((nextChar == '0' || nextChar == '1' || (nextChar) == '2' || (nextChar) == '3'
                            || nextChar == '4' || nextChar == '5' || nextChar == '6' || nextChar == '7' || nextChar == '8'
                            || (nextChar) == '9') && x < data[i].length());
                    if (nextChar == data[i].charAt(data[i].length() - 1)
                            && (nextChar == '0' || nextChar == '1' || (nextChar) == '2' || (nextChar) == '3'
                                    || nextChar == '4' || nextChar == '5' || nextChar == '6' || nextChar == '7'
                                    || nextChar == '8' || (nextChar) == '9')) {
                        System.out.println(data[i] + "       is a number");

                    }
                    else {
                        System.out.print("Error: " + data[i] + "   is not a number");
                        System.out.println();

                    }
                }
            }
        }
    }

}
