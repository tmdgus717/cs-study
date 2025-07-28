package stack;

public class StackTest {

    public static void main(String[] args) {
        var stack = new MyArrayStack<Integer>();
        stack.push(300);
        stack.push(200);
        stack.push(100);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
