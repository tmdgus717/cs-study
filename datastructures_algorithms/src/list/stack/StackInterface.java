package list.stack;

public interface StackInterface<E> {

    void push(E data);
    E pop();
    E peek();
    boolean isEmpty();
    void peekAll();
}
