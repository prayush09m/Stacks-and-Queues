 /*********************************************************/
 /* This class checks the queue. Whether its empty or not.*/
 /* Pushes and pops in values.                            */
 /* *******************************************************/
public class QueueCheck {
    char[] QueueItems;                  // Holds Queue Elements.
    int top;                            // Queue top pointer.
    int bottom;                         // Queue bottom pointer.

      /* This init method initiates when an equation is passed in next class.
      *  Instantiates the value QueueItems, and its pointer bottom and top */

    public void init(int number){
        this.QueueItems = new char[number];
        this.top = 0;
        this.bottom = -1;
    }
    /* This push method takes the character and pushes is up the queue.
    /*  The bottom value also increases, where as the top remains the same. */
    public void push(char character)
    {
        bottom++;
        QueueItems[bottom]  = character;
    }
    /* This method decreases the queue size and increases the top pointer. **/
    public char pop()
    {
       char word;
        word = QueueItems[top];
        top++;
        return word;
    }
    /* Checks if the Queue is Empty or not **/
    public boolean checkQueueIsEmpty(){
        if(top > bottom){
            return true;
        } else {
            return false;
        }
    }

     public char peek(){
         char peek;
         peek = QueueItems[top];
         return peek;
     }

}
