package stack;

public class StackRun {
    public static void main(String[] args) {
        StackArray stack = new StackArray(10);
        stack.push(1);
        stack.push(8);
        stack.push(25);
        stack.push(23);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }
}
