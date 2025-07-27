package list.linkedlist;

import list.ListInterface;

public class MyCircularLinkedList <E> implements ListInterface<E> {
    private Node<E> tail;
    private int numItems;

    public MyCircularLinkedList() {
        numItems = 0;
        tail = new Node(-1);
        tail.next = tail;
    }

    @Override
    public void add(int index, E data) {
        if (index >= 0 && index <= numItems) {
            Node<E> prevNode = getNode(index - 1);
            Node<E> newNode = new Node(data, prevNode.next);
            prevNode.next = newNode;
            if (index == numItems) {
                tail = newNode;
            }
            numItems++;
        }
    }

    @Override
    public void append(E data) {
        //LinkedList 처럼 끝 노드를 찾을 필요가 없어져서 append가 O(1) 로 구현 가능
        Node<E> prevNode = tail; //끝노드
        Node<E> newNode = new Node(data, tail.next); // 새노드가 더미노드를 가르키도록 구현
        prevNode.next = newNode;
        tail = newNode;
        numItems++;
    }

    @Override
    public E remove(int index) {
        if (index >= 0 && index <= numItems - 1) {
            Node<E> prevNode = getNode(index - 1);
            E rItem = prevNode.next.item;
            prevNode.next = prevNode.next.next;
            if (index == numItems) { //삭제된 노드가 tail 노드일경우 이전 노드를 tail노드로 변경
                tail = prevNode;
            }
            numItems--;
            return rItem;
        }
        return null;
    }

    @Override
    public boolean removeItem(E data) {
        Node<E> curNode = tail.next;
        Node<E> prevNode;
        for (int i = 0; i < numItems; i++) {
            prevNode = curNode;
            curNode = prevNode.next;
            if (((Comparable) curNode.item).compareTo(data) == 0) {
                prevNode.next = curNode.next;
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
        }
        return null;
    }

    @Override
    public void set(int index, E data) {
        if (index >= 0 && index <= numItems - 1) {
            getNode(index).item = data;
        }else {
            System.out.println("에러처리");
        }
    }

    private Node<E> getNode(int index) {
        if (index >= -1 && index <= numItems) {
            Node<E> currNode = tail.next;
            for (int i = 0; i <= index; i++) {
                currNode = currNode.next;
            }
            return currNode;
        }
        else return null;
    }

    public final int NOT_FOUND = -12345;
    @Override
    public int indexOf(E data) {
        Node<E> currNode = tail.next; //더미 헤드
        for (int i = 0; i <= numItems - 1; i++) {
            currNode = currNode.next;
            if (((Comparable) currNode.item).compareTo(data) == 0) {
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
        tail = new Node(-1);
        tail.next = tail;
    }
}
