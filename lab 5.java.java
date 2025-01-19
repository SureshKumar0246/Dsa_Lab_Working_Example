

public class CircularLinked {

    Node head;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void insertAtAtart(int data) {
        Node newNode = new Node(data);

        if (head == null)
        {
            head = newNode;
            newNode.next = head;
            return;
        }

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        newNode.next = head;
        head = newNode;
        temp.next = head;
    }

    public void insertEnd(Node prev_node, int newdata) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node newNode = new Node(newdata);
        newNode.next = prev_node.next;
        prev_node.next = newNode;
    }

    public void insertAtEnd(int newdata) {
        Node newNode = new Node(newdata);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;
    }

    public void deleteBeg() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }

        if (head.next == head) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        head = head.next;
        temp.next = head;
    }

    public void deleteEnd() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }

        if (head.next == head) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next.next != head) {
            temp = temp.next;
        }

        temp.next = head;
    }

    public void deleteFromPosition(int position) {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }

        if (position == 1) {
            deleteBeg();
            return;
        }

        Node temp = head;
        for (int i = 1; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        if (temp.next == head) {
            System.out.println("Position out of bounds");
            return;
        }

        temp.next = temp.next.next;
    }

    public void printList() {
        if (head == null) {
            System.out.println("No node added yet, List is empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to head)");
    }

    public static void main(String[] args) {
        CircularLinked list = new CircularLinked();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        System.out.println("List after inserting nodes at the end:");
        list.printList();

        list.insertAtAtart(5);
        System.out.println("List after inserting 5 at the head:");
        list.printList();

        list.insertEnd(list.head.next, 15); // Insert 15 after the second node
        System.out.println("List after inserting 15 after the second node:");
        list.printList();

        list.deleteBeg();
        System.out.println("List after deleting from start:");
        list.printList();

        list.deleteEnd();
        System.out.println("List after deleting from end:");
        list.printList();

        list.deleteFromPosition(2);
        System.out.println("List after deleting node at position 2:");
        list.printList();
    }
}
