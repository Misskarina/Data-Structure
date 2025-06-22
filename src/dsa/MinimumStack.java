import java.util.*;

public class MinimumStack {
    Stack<Integer> s = new Stack<>();
    Stack<Integer> min = new Stack<>();

    void push(int x) {
        s.push(x);
        if (min.isEmpty() || x <= min.peek()) min.push(x);
        else min.push(min.peek());
    }

    void pop() {
        if (!s.isEmpty()) {
            s.pop();
            min.pop();
        }
    }

    int top() { return s.peek(); }

    int getMin() { return min.peek(); }

    public static void main(String[] args) {
        MinimumStack ms = new MinimumStack();
        int[] a = {6, 9, -1, 2, 3};
        for (int x : a) {
            ms.push(x);
            System.out.println("Pushed: " + x + ", Min: " + ms.getMin());
        }
    }
}
