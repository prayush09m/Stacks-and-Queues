/***************************************************************************/
/* Class to evaluate the PostFixEvaluation. This class is for int values   */
/* only.                                                                   */
/***************************************************************************/


public class PostFixEvaluations
{
    String equations;                                   // each individual equations is stored in this variable.
    int numberOfEquations;                              // the total number of equations passed into constructor is stored here.
    StackCheck[] StackObject;                           // declaring StackCheck array object under the name StackObject.

    int answer = 0;                                     // The int value after the calculations are done.
    char last =' ';                                     // char value of the final answer is stored here.

    // Constructor that takes in the total string of equation and tells how many equations are present.
    // The constructor later takes the program to instantiate the above declared object and further calculations.
    public PostFixEvaluations(String equations, int numberOfEquations){
        this.equations = equations;
        this.numberOfEquations = numberOfEquations;
        StackObject = new StackCheck[numberOfEquations];
        instantiate();
        breakdown();

    }

    // This method instantiates the program object and prevents the null point exception error.
    public void instantiate(){

        for (int i = 0; i < this.numberOfEquations; i++){
                StackObject[i] = new StackCheck();

        }
    }
    // This method breaks down the one whole length of equation into several parts and hence proceed finally for calculations.
    public void breakdown(){
        String[] split = this.equations.split("     ");
        for(int i =0; i<split.length; i++){
            StackObject[i].init(split[i].length());
           Evaluate(split[i], i);
        }
    }

    // This methods finally evaluates the postflix equations.
    public void Evaluate(String toEvaluate,int index){
        int length = toEvaluate.length();

        int k = 0;

        while(k < length){

           char next = toEvaluate.charAt(k);

            if(Character.isDigit(next)){

               StackObject[index].push(next);

            } else if (next =='+' || next == '-' || next == '/' || next == '*'){

                char dos = StackObject[index].pop();

                char uno = StackObject[index].pop();

                int first = (int) dos - 48;

                int second = (int) uno -48;

                if (next == '+') {
                    answer = first + second;
                } else if (next == '-'){
                    answer = second - first;

                } else if (next == '*'){
                    answer = first * second;

                } else if (next == '/'){
                    answer = second/first;


                }
                answer = answer + 48;
                last = (char) answer;

                StackObject[index].push(last);
            }
            k++;
        }

        System.out.println("The final answer for equation " + toEvaluate + " is: " + ( (int)StackObject[index].pop()- 48 ) );
    }


}
