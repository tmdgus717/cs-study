package heap;

public class HeapTest {

    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>(5);
        try {
            heap.insert(1);
            heap.insert(10);
            heap.clear();
            heap.insert(30);
            heap.insert(10);
            heap.insert(30);
            heap.insert(20);
            heap.insert(40);
            heap.deleteMax();
            heap.insert(1);
            heap.insert(3); // PQException 발생
        } catch (PQException e) {
            System.out.println(e.getMessage());
        }

    }
}
