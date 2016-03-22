/*********************************************************************************/
/* Class to Convert Inflix equations to postflix. It takes the validated string  */
/* passed from the Parenthesis validation class. The operation is conducted on   */
/* these equations.                                                              */
/*********************************************************************************/
public class InflixToPostFlix
{
    String equation;                    // The whole list of equation as one string.
    int numberOfQueue;                  // The total number of equations in the equation String.
    QueueCheck[] QOperator;             // Assign the QOperator as an QueueCheck object.
    StackCheck[] SOperator;             // Assign the SOperator as an StackCheck object.
    String sum = "";                    // One String combined after converting all equations in the file.

    /** Method to bring in equation and assigning the size of QOperator and SOperator.
     *  Also proceed the program to instantiate new object and separate the given equations.
     **/

    public InflixToPostFlix(String equation, int numberOfQueue){

        this.equation = equation;
        this.numberOfQueue = numberOfQueue;
        QOperator = new QueueCheck[numberOfQueue];
        SOperator = new StackCheck[numberOfQueue];
        DeclareObject();
        seperateEquation();

    }

    /** Instantiate every array object. **/

    public void DeclareObject()
    {
        for(int i = 0; i < numberOfQueue;i++)
        {
            QOperator[i] = new QueueCheck();
            SOperator[i] = new StackCheck();
        }
    }
    /** Seperate my summed up equation and further sends individual equation for converting. **/
    public void seperateEquation(){

        String[] equ = equation.split("     ");

        for(int i = 0; i < equ.length; i++)
        {

            QOperator[i].init(equ[i].length());                     // Initializes my Queue.
            SOperator[i].init(equ[i].length());                     // Initializes my Stack.
            Conversion(equ[i], i);                                  // Sends the code to convert from inflix to postflix.
            sum = sum + "     ";
        }
    }

    /** Method which converts the valid equation from inflix to post flix **/

    public void Conversion(String equations, int num){


        int i = 0;
        while(i < equations.length()) {                                 // loop to search every character in equation
            char nextchar = equations.charAt(i);                        // selects the next character in the equation.

         // If the character is operator, checks the precedence. If the precedence is higher push the top operator from
         // the stack else push the operator on the stack.
           if(!Character.isDigit(nextchar) && nextchar != '(' && nextchar != ')' ){

               while(SOperator[num].peek() != '(' && !SOperator[num].isStackItemsEmpty() && checkPrecedence(nextchar,num)){

                   QOperator[num].push(SOperator[num].pop());

               }


               SOperator[num].push(nextchar);

           // If the character is a number, then push it in the queue.
           } else if (Character.isDigit(nextchar)){


               QOperator[num].push(nextchar);
           // If the character is left parenthesis, push it on the stack.
           } else if (nextchar == '('){

               SOperator[num].push(nextchar);

           // If the character is right parenthesis, go to method pushInParen, which pushes every character from stack
           // to queue.
           } else if(nextchar == ')'){
               pushInParen(num);
           }

            i++;
        }

        // Method to push the remaining stack items to queue.
        StackToQueue(num);

        print(equations,num);
    }


    /** Method to push all the operators in the stack to queue until the left parenthesis is found. **/
    public void pushInParen(int num){
        // Until we find left parenthesis and the stack is not empty the loop continues to run.
        while(SOperator[num].peek() != '(' && !SOperator[num].isStackItemsEmpty()){
            QOperator[num].push(SOperator[num].pop());
        }
        if (SOperator[num].peek() == '('){
            char Random = SOperator[num].pop();
        }
    }


    /** Method to push all the remaining Stack items to queue. **/
    public void StackToQueue(int num){
        while(!SOperator[num].isStackItemsEmpty() ){

            if(SOperator[num].peek() != '(') {
                QOperator[num].push(SOperator[num].pop());
            } else {
                char popped = SOperator[num].pop();
            }
        }
    }
    /** Method to check the precedence of the operators incoming in the stack. **/
    public boolean checkPrecedence(char nextchar, int num){
        // if the precedence of the incoming operator is lower than the existing operator return true.
            if(nextchar == '+' || nextchar == '-') {
                if (SOperator[num].peek() == '*' || SOperator[num].peek() == '/') {
                       return true;
                }
            }
        // if the precedence of the incoming operator is higher than the existing operator return false.

        if(nextchar == '*' || nextchar == '/') {
            if (SOperator[num].peek() == '+' || SOperator[num].peek() == '-') {
                return false;
            }
        }
        // if the precedence of the incoming operator is same than the existing operator return false.

        if(nextchar == '+' || nextchar == '-') {
            if (SOperator[num].peek() == '+' || SOperator[num].peek() == '-') {
               return true;
            }
        }
        // if the precedence of the incoming operator is same than the existing operator return false.

        if(nextchar == '*' || nextchar == '/') {
            if (SOperator[num].peek() == '*' || SOperator[num].peek() == '/') {
                return true;
            }
        }
        return false;

    }

    /** Method to print the queue, hence displaying the post fix equation. **/

    public void print(String equation, int num){
        System.out.print("The postflix equation for " + equation + " is: " );
    while(!QOperator[num].checkQueueIsEmpty()){
        sum += QOperator[num].peek();
      System.out.print(QOperator[num].pop());
    }
        System.out.println();
    }

    public String getSum(){
        return this.sum;
    }


}
