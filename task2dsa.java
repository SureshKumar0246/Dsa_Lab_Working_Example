public class LinkList{
    
    private Node top;
     public static class Node{
            public int data;
            public Node next;
            public Node(int data){
            this.data = data;
            this.next = null;
            
        }
        }
        public void push(int elemnt) {
            Node newNode = new Node(elemnt);
            newNode.next = top;
            top = newNode;
        }
        public Node pop(){
            Node temp = top;
            top = top.next;
            return temp;
        }
        public void displayList(){
            Node current = top;
            while(current != null){
              System.out.print(current.data+ "-> ");
              current = current.next;
            }
        }
    public static void main (String[] args) {
       LinkList stack = new LinkList();
       stack.push(20);
     stack.push(30);
     stack.push(40);
     stack.push(50);
     stack.push(60);
     
     stack.displayList();
     stack.pop();
    System.out.println();
    System.out.println("After Pop");
     stack.displayList();
    }
}