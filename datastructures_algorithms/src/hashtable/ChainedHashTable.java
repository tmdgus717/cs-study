package hashtable;


import list.linkedlist.MyLinkedList;
import list.linkedlist.Node;

public class ChainedHashTable {
    private MyLinkedList<Integer>[] table; //테이블의 각 원소는 연결 리스트를 가리키게 된다
    int numItems = 0;

    public ChainedHashTable(int size) {
        this.table = (MyLinkedList<Integer>[]) new MyLinkedList[size];
        //배열마다 리스트 생성
        for (int i = 0; i < size; i++) {
            table[i] = new MyLinkedList<>();
        }
        this.numItems = 0;
    }

    private int hash(Integer x) {
        //간단한 나눗셈 기반의 해쉬 함수
        return x % table.length;
    }

    public void insert(Integer x) {
        int slot = hash(x);
        table[slot].add(0, x);
        numItems++;
    }

    public Node search(Integer x) {
        int slot = hash(x);
        if (table[slot].isEmpty()) return null;
        else{
            int i = table[slot].indexOf(x);
            return table[slot].getNode(i);
        }
    }

    public void delete(Integer x) {
        if(isEmpty()){
            System.out.println("빈 해시테이블 입니다.");
        }else{
            int slot = hash(x);
            table[slot].removeItem(x);
            numItems--;
        }
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public void clear() {
        for (int i = 0; i < table.length; i++) {
            table[i] = new MyLinkedList<>();
        }
        numItems = 0;
    }
}
