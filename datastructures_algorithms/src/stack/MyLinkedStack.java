package stack;

import list.linkedlist.Node;

public class MyLinkedStack<E> implements MyStack<E> {

    private Node<E> topNode;
    private final E ERROR = null;

    public MyLinkedStack() {
        this.topNode = null;
    }

    @Override
    public void push(E item) {
        var newNode = new Node<>(item, topNode);
        topNode = newNode;
    }

    @Override
    public E pop() {
        if(isEmpty()) return ERROR;
        else{
            Node<E> temp = topNode;
            topNode = topNode.next;
            return temp.item;
        }
    }

    @Override
    public E top() {
        if (isEmpty()) return ERROR;
        return topNode.item;
    }

    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    @Override
    public void popAll() {
        topNode = null;
    }
}
