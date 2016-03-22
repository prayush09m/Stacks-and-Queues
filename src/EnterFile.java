import javafx.geometry.Pos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/************************************************************************/
/* Class to Upload the txt file and pass it to perform respective tasks.*/
/*************************************************************************/
public class EnterFile{
    String sentenceOfEquations = "";                    // Individual equation as string data type.
    String summedUp = "";                               // All the equations joined up in one string.
    int numberOfEquations = 0;                          // Total number of equations in the file.

    /* Constructor for EnterFile class. Begins the program and
    /* prompts the user to enter the text file's address.   */

    public EnterFile(){
         System.out.println("Welcome to my program");
         fileUpload();
    }

    /* Method to upload the text file, break and make all the text as one integer.
    /* Also, passes the instruction to execute Parenthesis Validation, Infix to
    /* PostFix Expression Conversion, and PostFix Expression Evaluation. */


    public void fileUpload(){

        Scanner input = null;
        try {

            input = new Scanner(new File(EnterFileName()));  // Uploads the txt file and prompts to EnterFileName method

            while(input.hasNextLine()){                      // Reads the text file and attaches the string as one

                sentenceOfEquations = input.nextLine();
                summedUp += sentenceOfEquations + "     ";
                numberOfEquations++;
            }

            ParenthesesCheck checkParanthesis = new ParenthesesCheck(summedUp,numberOfEquations);
                                                              // Executes the constructor of checkParenthesisClass.

            InflixToPostFlix inflixToPostFlix = new InflixToPostFlix(checkParanthesis.getSummed(),checkParanthesis.getNumber());
                                                             // Executes the constructor to convert the equations.

            PostFixEvaluations evaluatePostFix = new PostFixEvaluations(inflixToPostFlix.getSum(),checkParanthesis.getNumber());
        }

        catch (FileNotFoundException e){                      // Throws file not found exception if invalid is entered.
            System.out.println("File Not Found");
            System.out.println("Re-enter the file Name");
            this.fileUpload();
        }
        finally {                                             // Closes up the file, so other application can access it.
                input.close();
        }
    }


    /* Method to ask the user about the file Address and passes as an txt file address */

    public static String EnterFileName(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the address of the file. [Ex: C:\\Users\\prayu\\Desktop\\390 Assignment 3\\src\\Equations.txt] ");
        String address = scan.nextLine();
        return address;
    }

}
