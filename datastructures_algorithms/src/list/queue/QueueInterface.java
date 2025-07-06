package list.queue;

public interface QueueInterface<E> {
    public void enqueue(E x);
    public E dequeue();
    public E peek();
    public boolean isEmpty();
    public void dequeueAll();
}


