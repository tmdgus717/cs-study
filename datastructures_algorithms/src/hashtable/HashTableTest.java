package hashtable;

import list.linkedlist.Node;

public class HashTableTest {

    public static void main(String[] args) {
        ChainedHashTable h = new ChainedHashTable(11);
        h.insert(10);
        h.delete(10);
        h.insert(20);

        h.insert(5);
        h.insert(80);
        h.insert(590);

        h.delete(20);
        h.delete(44);

        Node<Integer> node = h.search(80);
        if (node == null) {
            System.out.println("Search Failed!");
        }else {
            System.out.println("Found : " + node.item);
        }
    }
}
