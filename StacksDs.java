import java.util.Stack;

public class StacksDs {
    
    private Stack<Double> mainStack = new Stack<>();
    private Stack<Double> maxStack = new Stack<>();

    public void push(double value) {
        mainStack.push(value);

        if (maxStack.isEmpty() || value >= maxStack.peek()) {
            maxStack.push(value);
        }
    }
    
    public Double pop() {
        if (mainStack.isEmpty()) {
            return null;
        }

        double poppedValue = mainStack.pop();

        if (poppedValue == maxStack.peek()) {
            maxStack.pop();
        }

        return poppedValue;
    } 

}
