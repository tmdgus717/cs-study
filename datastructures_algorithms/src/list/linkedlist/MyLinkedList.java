package list.linkedlist;

import list.ListInterface;

public class MyLinkedList<E> implements ListInterface<E> {

    private ListNode<E> head;
    int count;

    public MyLinkedList() {
        this.head = null;
        this.count = 0;
    }

    @Override
    public void insertElement(int position, E data) {
        int i;
        ListNode<E> tempNode = head;
        ListNode<E> newNode = new ListNode<>(data);

        if (position < 0 || position > count) {
            System.out.println("위치오류입니다.");
        }

        if (position == 0) {
            //맨 앞 이면 newNode가 head가 된다.
            newNode.next = head;
            head = newNode;
        }else {
            ListNode<E> preNode = null;
            for (i = 0; i < position; i++) {
                preNode = tempNode;
                tempNode = tempNode.next;
            }
            //순서 중요!!
            newNode.next = preNode.next;
            preNode.next = newNode;
        }

        count++;
    }

    @Override
    public void addElement(E data) {
        ListNode newNode;

        if (head == null) {
            newNode = new ListNode(data);
            head = newNode;
        }else {
            //마지막 노드까지 찾아가기 next가 null인 node 찾기
            newNode = new ListNode(data);
            ListNode tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = newNode;
        }

        count++;
    }

    @Override
    public E removeElement(int position) {

        int i;
        ListNode<E> tempNode = head;

        if (position < 0 || position >= count) {
            System.out.println("위치오류입니다.");
            return null;
        }

        if (position == 0) {
            head = tempNode.next;
        }
        else {//중간위치라면
            ListNode<E> preNode = null;
            for (i = 0; i < position; i++) {

                preNode = tempNode;
                tempNode = tempNode.next;
            }

            preNode.next = tempNode.next; //tempNode 삭제
        }
        count--;
        return tempNode.getData();
    }

    @Override
    public E getElement(int position) {

        int i;
        ListNode<E> tempNode = head;

        if (position < 0 || position >= count) {
            System.out.println("위치오류입니다.");
            return null;
        }

        if (position == 0) {
            return head.getData();
        }

        for (i = 0; i < position; i++) {
            tempNode = tempNode.next;
        }

        return tempNode.getData();
    }

    @Override
    public int getSize() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        if (head == null) return true;
        return false;
    }

    @Override
    public void removeAll() {
        head = null;
        count = 0;
    }

    @Override
    public void printAll() {
        if (count == 0) {
            System.out.println("빈 리스트 입니다.");
            return;
        }

        ListNode<E> tempNode = head;
        while (tempNode.next != null) {
            System.out.println(tempNode.getData());
            tempNode = tempNode.next;
        }
        System.out.println(tempNode.getData());
    }

    public void reverseList() {
        if(head == null) return;

        ListNode<E> currentNode = null;
        ListNode<E> preNode = null;
        ListNode<E> nextNode = head;
        while (nextNode != null) {
            preNode = currentNode; //이전 노드를 현재 노드로!!
            currentNode = nextNode;
            nextNode = nextNode.next;
            currentNode.next = preNode; //
        }

        head = currentNode;
    }
}
