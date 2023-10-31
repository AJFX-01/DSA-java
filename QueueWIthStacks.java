import java.util.Stack;

public class QueueWIthStacks<T>{

    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>(); 


    public void enqueue(T item) {
        stack1.push(item);
    }

    public T dequeue() {
        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) {
            return null;
        }

        return stack2.pop();
    }

    
}