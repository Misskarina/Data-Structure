import java.util.Stack;

public class MyQueue {

    // FIFO Queue implemented using two stacks
    static class MyQueues {
        private Stack<String> inStack;
        private Stack<String> outStack;

        public MyQueues() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        // Add item to back of queue
        public void push(String x) {
            inStack.push(x);
        }

        // Remove item from front of queue
        public String pop() {
            shiftStacks();
            return outStack.pop();
        }

        // Peek front of queue
        public String peek() {
            shiftStacks();
            return outStack.peek();
        }

        // Check if queue is empty
        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }

        // Move items from inStack to outStack only when needed
        private void shiftStacks() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
        }
    }

    // Main method to test queue with string input
    public static void main(String[] args) {
        MyQueues queue = new MyQueues();

        // Push elements into queue
        queue.push("Bag");
        queue.push("Pen");
        queue.push("Bottle");
        queue.push("NoteBook");
        queue.push("IdCard");

        // Pop and print each element in FIFO order
        System.out.println("Items in queue (FIFO order):");
        while (!queue.empty()) {
            System.out.println(queue.pop());
        }
    }
}
