package stack;

import java.util.LinkedList;

public class InheritedStack<E> extends LinkedList<E> implements MyStack<E> {

    public InheritedStack(){
        super();
    }

    public void push(E item) {
        add(0, item);
    }

    public E pop() {
        if (!isEmpty()){
            return remove(0);
        }
        return null;
    }

    @Override
    public E top() {
        return get(0);
    }

    @Override
    public void popAll() {
        clear();
    }
}
