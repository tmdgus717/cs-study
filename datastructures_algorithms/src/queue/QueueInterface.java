package queue;

public interface QueueInterface <E>{

    void enqueue(E data);

    E dequeue();

    E front();

    boolean isEmpty();

    void dequeAll();
}
