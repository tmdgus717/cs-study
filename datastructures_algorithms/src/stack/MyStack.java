package stack;

public interface MyStack<E> {

    void push(E item);
    E pop();
    E top();
    boolean isEmpty();
    void popAll();
}
