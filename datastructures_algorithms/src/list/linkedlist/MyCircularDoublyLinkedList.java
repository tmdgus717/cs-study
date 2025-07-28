package list.linkedlist;

import list.ListInterface;

public class MyCircularDoublyLinkedList<E> implements ListInterface<E> {

    private BidirectionalNode<E> head;
    private int numItems;

    public MyCircularDoublyLinkedList() {
        numItems = 0;
        head = new BidirectionalNode<>(); // 더미 헤드
        head.next = head.prev = head;
    }

    @Override
    public void add(int index, E item) {
        if (index >= 0 && index <= numItems) {
            var prevNode = getNode(index - 1);
            var newNode = new BidirectionalNode<>(prevNode, prevNode.next, item); //이전 다음 노드 저장
            newNode.next.prev = newNode; //내 다음노더의 이전은 나를 가리켜야함
            prevNode.next = newNode; //이전 노드의 다음도 나를 가리켜야함
            numItems++;
        }else {
            System.out.println("인덱스 에러");
        }
    }

    @Override
    public void append(E item) {
        var prevNode = head.prev;
        var newNode = new BidirectionalNode<>(prevNode, head, item);
        prevNode.next = newNode;
        head.prev = newNode;
        numItems++;
    }

    @Override
    public E remove(int index) {
        if (index > 0 && index <= numItems - 1) {
            var currNode = getNode(index);
            currNode.prev.next = currNode.next; // 나는 지워지므로 내 이전노드가 내 다음노드를 가리키도록 변경
            currNode.next.prev = currNode.prev; // 나는 지워지므로 내 다음노드가 내 이전노드를 가리키도록 변경
            numItems--;
            return currNode.item;
        }
        return null;
    }

    @Override
    public boolean removeItem(E item) {
        var currNode = head; // 더미 헤드
        for (int i = 0; i <= numItems; i++) {
            currNode = currNode.next;
            if (((Comparable) (currNode.item)).compareTo(item) == 0) {
                currNode.prev.next = currNode.next;
                currNode.next.prev = currNode.prev;
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
        return null; //에러
    }

    @Override
    public void set(int index, E item) {
        if (index >= 0 && index <= numItems - 1) {
            getNode(index).item = item;
        }else {
            System.out.println("인덱스 에러");
        }
    }

    public BidirectionalNode<E> getNode(int index){
        if(index >= -1 && index <= numItems -1){
            var currNode = head;
            if(index < numItems/2){
                for (int i = 0; i <= index; i++) {
                    currNode = currNode.next;
                }
            }else{
                for (int i = numItems - 1; i >= index; i--) {
                    currNode = currNode.prev;
                }
            }
            return currNode;
        }else {
            return null;
        }
    }

    public final int NOT_FOUND = -12345;

    @Override
    public int indexOf(E item) {
        var currNode = head;
        for (int i = 0; i <= numItems - 1; i++) {
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
        head.next = head.prev = head;
    }
}
