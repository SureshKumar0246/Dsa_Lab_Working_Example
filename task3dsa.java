public class Queue {
    int front, size, capacity;
    int array[];

    // Constructor: Initializes the queue with a specific capacity
    public Queue(int length) {
        capacity = length;
        front = size = 0;
        array = new int[capacity];
    }

    // Check if the queue is full
    public boolean isFull() {
        return (size == capacity);
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return (size == 0);
    }

    // Enqueue operation: Add an item to the queue
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot enqueue " + item);
            return;
        }
        int pos = (front + size) % capacity;
        array[pos] = item;
        size++;
        System.out.println(item + " enqueued to queue");
    }

    // Dequeue operation: Remove and return an item from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return -1; // Return -1 to indicate an empty queue
        }
        int item = array[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    // Get the front item of the queue without removing it
    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty! No front item.");
            return -1; // Return -1 to indicate an empty queue
        }
        return array[front];
    }

    // Get the current size of the queue
    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
     
        Queue queue = new Queue(10);

        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println("Queue size: " + queue.getSize());

     
        queue.enqueue(77);

     
        System.out.println(queue.dequeue() + " dequeued from queue");

        System.out.println("Front item: " + queue.front());
    }
}
