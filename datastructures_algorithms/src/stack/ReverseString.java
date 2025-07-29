package stack;

public class ReverseString {

    public static void main(String[] args) {
        String input = "Test Seq 12345";
        String t = reverse(input);
        System.out.println("Input String: " + input);
        System.out.println("Reversed String: " + t);
    }

    private static String reverse(String input) {
        MyArrayStack<Character> st = new MyArrayStack<>(input.length());
        for (int i = 0; i < input.length(); i++) {
            st.push(input.charAt(i));
        }
        String output = "";
        while (!st.isEmpty()) {
            output += st.pop();
        }
        return output;
    }

}
