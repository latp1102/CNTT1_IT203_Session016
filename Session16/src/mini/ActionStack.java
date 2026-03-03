package mini;

import java.util.Stack;

public class ActionStack<T> {
    private Stack<T> stack = new Stack<>();

    public void push(T item) {
        stack.push(item);
    }
    public T pop() {
        return stack.isEmpty() ? null : stack.pop();
    }

    public T peek() {
        return stack.isEmpty() ? null : stack.peek();
    }
}
