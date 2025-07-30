package queue;

public class ArrayQueue<E> implements QueueInterface<E> {

    private E queue[];
    private int front, tail, numItems;
    private static final int DEFAULT_CAPACITY = 64;
    private final E ERROR = null;

    public ArrayQueue() {
        queue = (E[]) new Object[DEFAULT_CAPACITY];
        front = 0;
        tail = DEFAULT_CAPACITY - 1; // 원형큐에 enqueue를 통일하기 위해서
        numItems = 0;
    }

    public ArrayQueue(int size) {
        queue = (E[]) new Object[size];
        front = 0;
        tail = size - 1;
        numItems = 0;
    }

    @Override
    public void enqueue(E data) {
        if (isFull()) {
            System.out.println("Queue Full!");
        }
        else{
            tail = (tail + 1) % queue.length; //tail -> 0
            queue[tail] = data;
            ++numItems;
        }
    }

    public boolean isFull() {
        return (numItems == queue.length);
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return ERROR;
        }
        E queueFront = queue[front]; //반환할 값
        front = (front + 1) % queue.length; //원형 큐
        --numItems;
        return queueFront;
    }

    @Override
    public E front() {
        if (isEmpty()) {
            return ERROR;
        }
        return queue[front];
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public void dequeAll() {
        queue = (E[]) new Object[queue.length]; // 이전에 저장된 데이터 가바지 컬렉션의 대상이 되도록
        front = 0;
        tail = queue.length - 1;
        numItems = 0;
    }
}
