package queue;

import stack.MyLinkedStack;

public class Palindrom {

    public static void main(String[] args) {
        System.out.println("Palindrom Cehck!");
        String str = "lioninoil";
        boolean t = isPalindrome(str);
        System.out.println(str + " is Palindrom?:" + t);
    }

    public static boolean isPalindrome(String s) {
        MyLinkedStack<Character> stack = new MyLinkedStack<>();
        LinkedQueue<Character> queue = new LinkedQueue<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
            queue.enqueue(s.charAt(i));
        }

        while (!stack.isEmpty() && (stack.pop() == queue.dequeue())) {
            //팰린드롬이 아니라면 중간에 while 문이 실패하고 stack or queue에 값이 남아있게된다!!
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
