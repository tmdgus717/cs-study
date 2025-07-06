package list.linkedlist;

public class ListNode<E> {

    E data;
    public ListNode<E> next;

    public ListNode() {
        this.data = null;
        this.next = null;
    }

    public ListNode(E data) {
        this.data = data;
        this.next = null;
    }

    public ListNode(E data, ListNode<E> next) {
        this.data = data;
        this.next = next;
    }

    E getData() {
        return data;
    }
}
