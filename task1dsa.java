/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Stack
{
    private int arr[];
    private int size;
    private int index = 0;
    
    public Stack(int size){
        this.size = size;
        arr = new int[size];
    }
    public boolean isFull(){
        if (index == size){
          return true;
         } 
         else {
             return false;
         }
    }
    public boolean isEmpty(){
        if(index == 0){
            return true;
        }
            return false;
    }
    
    public void push(int element){
        if(isFull()){
            System.out.println("Stack is full");
        }
        else{
            arr[index] = element;
            index++;
        }
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is isEmpty");
        }
       
            return arr[--index];
        
    }
    public int Size(){
        return index;
    }
	public static void main(String[] args) {
       Stack stack = new Stack(5);
       stack.push(20);
       stack.push(30);
       stack.push(40);
       stack.push(50);
       stack.push(60);
                   System.out.println("Size of amn Array After push "+stack.Size());
                 System.out.println("Pop Element Froim Stack ");
         while(!stack.isEmpty()){
                         System.out.println(stack.pop());

         }
       System.out.println("Size of amn Array After pop "+stack.Size());
	}
}