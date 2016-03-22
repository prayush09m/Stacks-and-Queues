/***************************************************************************/
/* Class to check the Parentheses Validation. It takes the string passed   */
/* the EnterFile class and determines the given equation in the txt files  */
/* is valid or not.                                                        */
/***************************************************************************/

public class ParenthesesCheck {
    int numberOfEquations;                      // Number of Equations in the text file.
    String equation;                            // All equation as one whole string.
    StackCheck operator = new StackCheck();     // Declaring the StackCheck Object.
    String summed = "";                         // Sum of all valid equations.
    int number = 0;                             // Number of valid equations.


    /* This method takes in the value and implements new method to seperate the single string */

    public ParenthesesCheck(String equation, int numberOfEquations){
        this.equation = equation;
        this.numberOfEquations = numberOfEquations;

        seperateString();
    }


    /* Seperates the string, and stores it like an element of String Array. */


    public void seperateString(){
        String[] equations = equation.split("     ");

       for(int i =0; i < this.numberOfEquations; i++){

        boolean valid = check(equations[i]);
       }
    }

    /* Method to check whether the equation passed from seperateString method is valid or invalid. */

    public boolean check(String toCheck){
        int i = 0;
        operator.init(this.numberOfEquations);

        while(i < toCheck.length()){

            char nextChar = toCheck.charAt(i);


            if( nextChar == '('){
                operator.push(nextChar);
            }
            else if(nextChar == ')'){
                if (operator.isStackItemsEmpty()){

                    System.out.println("The Equation... " + toCheck + " is invalid. Comments: Too many ')'");
                    return false;
                } else {
                    char closeIt = operator.pop();
                }
            }
            i++;

        }

        if(operator.isStackItemsEmpty() ){

            System.out.println("The Equation " + toCheck + " is valid.");

           this.summed += toCheck + "     ";
            this.number ++;
           return true;

        }else{
            System.out.println("The Equation " + toCheck + " is invalid. Comments: Too many '('");
            return false;
        }

    }




    public String getSummed(){
        return this.summed;
    }

    public int getNumber(){
        return this.number;
    }
}
