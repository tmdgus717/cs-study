package queue;

public class QueueTest {

    public static void main(String[] args) {
//        ArrayQueue<String> s = new ArrayQueue<>();
        LinkedQueue<String> s = new LinkedQueue<>();
        s.enqueue("test1");
        s.enqueue("test2");
        s.enqueue("test3");

        System.out.println(s.dequeue());
        System.out.println(s.front());
        System.out.println(s.dequeue());
    }

}
