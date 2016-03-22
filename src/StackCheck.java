 /*********************************************************/
 /* This class checks the stack. Whether its empty or not.*/
 /* Pushes, pops, peeks in values.                        */
 /* *******************************************************/
public class StackCheck {

    char[] StackItems;                      // Holds Char Stacks Elements
    int top;                                // Stack pointer
    char letter;                            // character usually is the top value of the Stack.

     /* This init method initiates when an equation is passed in next class.
      *  Instantiates the value StackItems and its pointer, top */

    public void init(int number){
        StackItems = new char[number];
        top = -1;
    }



     /* This push method takes the character and pushes is up the stack.
      *  The pointer value also increases as the stack increases. */

    public void push(char character)
    {
        top++;
        StackItems[top] = character;
    }


    /* This method decreases the stack size and decreases the pointer too */

    public char pop(){
        try{
            letter = StackItems[top];
            top--;
        }
       catch (ArrayIndexOutOfBoundsException e){

        }
        return letter;
    }

    /* This method checks whether the given stack is empty or not. */
    public boolean isStackItemsEmpty(){
        if(top == -1){
            return true;
        }
        else
        {
            return false;
        }
    }

     public char peek(){
         char popped = this.pop();
         this.push(popped);
         return popped;
     }

     public boolean checkLeft(){
         int here = top;
         while(!this.isStackItemsEmpty()){
             if(this.peek() == '('){
                 top = here;
                 return true;
             }
             top = top -1;
         }
         return false;

     }

     public void printStack(){
         int here = top;
         while(!this.isStackItemsEmpty()){
             System.out.print(this.peek());
             top = top -1;
         }
         top = here;

     }


}
