package list.linkedlist;

import list.ListInterface;

public class CircularLinkedList<E> implements ListInterface<E> {
    private ListNode<E> rear;
    private int numItems;

    @Override
    public void insertElement(int i, E x) {

    }

    @Override
    public void addElement(E data) {
        ListNode<E> prevNode = rear;
        ListNode<E> newNode = new ListNode(data, rear.next);
        prevNode.next = newNode;
        rear = newNode;
        numItems++;
    }

    @Override
    public E removeElement(int i) {
        return null;
    }

    @Override
    public E getElement(int i) {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void removeAll() {

    }

    @Override
    public void printAll() {

    }
}
