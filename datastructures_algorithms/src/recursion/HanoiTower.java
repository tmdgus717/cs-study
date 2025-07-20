package recursion;

public class HanoiTower {

    public static void move(int n, int a, int b,int c) { //a->b 로 이동하는 하노이탑알고리즘

        if (n > 0) {
            move(n - 1, a, c, b);
            System.out.printf("%d에 있는 원반을 %d로 옮긴다\n", a, b);
            move(n - 1, c, b, a);
        }
    }
    public static void main(String[] args) {
        move(3, 1, 2, 3);
    }
}
