package queue;

import list.linkedlist.Node;

public class LinkedQueue <E> implements QueueInterface<E>{

    private Node<E> tail; //레퍼런스 tail이 리스트의 마지막 노드를 가리키고 원형이므로 front 에 접근할 수 있다.
    private final E ERROR = null;

    public LinkedQueue() {
        tail = null;
    }

    @Override
    public void enqueue(E item) {
        Node<E> newNode = new Node<>(item);
        if (isEmpty()) {
            newNode.next = newNode;//1개이므로 자기자신을 가리키도록
            tail = newNode;
        }else{
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }

    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return ERROR;
        }
        Node<E> front = tail.next; //원형 연결리스트 방식이므로 tail.next == front

        if (front == tail)
            tail = null;
        else {
            tail.next = front.next; // tail 의 next 가 front 다음값을 가리키도록 변경
        }

        return front.item;
    }

    @Override
    public E front() {
        if (isEmpty()) {
            return ERROR;
        }

        return tail.next.item;
    }

    @Override
    public boolean isEmpty() {
        return tail == null;
    }

    @Override
    public void dequeAll() {
        tail = null;
    }
}
