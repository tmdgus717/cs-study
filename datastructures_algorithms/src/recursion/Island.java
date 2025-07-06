package recursion;

public class Island {
    public static class Node{
        String name;
        Node left;
        Node right;

        public Node(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node("H");
        Node n2 = new Node("F");
        Node n3 = new Node("S");
        Node n4 = new Node("U");
        Node n5 = new Node("E");
        Node n6 = new Node("Z");
        Node n7 = new Node("K");
        Node n8 = new Node("N");
        Node n9 = new Node("A");
        Node n10 = new Node("Y");
        Node n11 = new Node("T");

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n5.left = n9;
        n7.right = n10;
        n9.right = n11;

        System.out.println("Acourse");
        Acourse(n1);
        System.out.println("\nBcourse");
        Bcourse(n1);
        System.out.println("\nCcourse");
        Ccourse(n1);
    }

    public static void Acourse(Node node) { //방문한 지점부터 출력하고 왼쪽으로 탐색
        if (node != null) {
            System.out.print(node.name + " -> ");
            Acourse(node.left);
            Acourse(node.right);
        }
    }

    public static void Bcourse(Node node) {
        //왼쪽부터 탐색 -> 방문 -> 오른쪾 탐색
        if (node != null) {
            Bcourse(node.left);
            System.out.print(node.name + " -> ");
            Bcourse(node.right);
        }
    }

    public static void Ccourse(Node node) {
        if (node != null) {
            Ccourse(node.left);
            Ccourse(node.right);
            System.out.print(node.name + " -> ");
        }
    }
}
