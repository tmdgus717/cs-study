package list.linkedlist;

import list.ListInterface;

public class MyLinkedList<E> implements ListInterface<E> {
    private Node<E> head;
    private int numItems;

    public MyLinkedList() {
        this.head = new Node<>(null,null); //더미노드
        this.numItems = 0;
    }

    @Override
    public void add(int index, E item) {
        if (index >= 0 && index <= numItems) {
            Node<E> prevNode = getNode(index - 1);
            Node<E> newNode = new Node<>(item, prevNode.next);//이전 노드의 다음을 새 노드의 다음값으로 위치 변경
            prevNode.next = newNode;
            numItems++;
        }
    }

    @Override
    public void append(E item) {
        Node<E> prevNode = head;
        while (prevNode.next != null) {
            prevNode = prevNode.next;//이동
        }
        Node<E> newNode = new Node<>(item, null);
        prevNode.next = newNode;
        numItems++;
    }

    @Override
    public E remove(int index) {
        if (index >= 0 && index < numItems) {
            Node<E> prevNode = getNode(index - 1);
            Node<E> currNode = prevNode.next;
            prevNode.next = currNode.next; //이전 노드와 현재 노드의 링크를 제거
            numItems--;
            return currNode.item;
        }else{
            return null;
        }
    }

    @Override
    public boolean removeItem(E item) {
        Node<E> currNode = head;
        Node<E> prevNode;
        for (int i = 0; i < numItems; i++) {
            prevNode = currNode;
            currNode = currNode.next;
            if (((Comparable) (currNode.item)).compareTo(item) == 0) {
                prevNode.next = currNode.next;
                numItems--;
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index >= 0 && index <= numItems - 1) {
            return getNode(index).item;
        }else {
            return null;
        }
    }

    public Node<E> getNode(int index) {
        if (index >= -1 && index <= numItems - 1) {
            Node<E> currNode = head;
            for (int i = 0; i <= index; i++) {
                currNode = currNode.next;
            }
            return currNode;
        }else {
            return null;
        }
    }

    @Override
    public void set(int index, E item) {
        if (index >= 0 && index <= numItems - 1) {
            getNode(index).item = item;
        }
        else {
            /*에러처리*/
        }
    }

    public final int NOT_FOUND = -12345;
    @Override
    public int indexOf(E item) {
        Node<E> currNode = head;
        for (int i = 0; i < numItems; i++) {
            currNode = currNode.next;
            if (((Comparable) (currNode.item)).compareTo(item) == 0) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    @Override
    public int len() {
        return numItems;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public void clear() {
        numItems = 0;
        head = new Node<>(null, null);
    }
}
