package index;

public class BinarySearchTreeTest {

    public static void main(String[] args) {
        var bst1 = new BinarySearchTree();
        bst1.insert(10);
        bst1.insert(20);
        bst1.insert(5);
        bst1.insert(80);
        bst1.insert(90);
        bst1.insert(75);
        bst1.insert(30);
        bst1.insert(77);
        bst1.insert(15);
        bst1.insert(40);

        System.out.println(bst1.search(77));
        bst1.delete(20);
    }

}
