package list.arraylist;

public class MyArrayListTest {

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(0, 300);
        list.add(0, 200);
        list.add(0, 100);

        list.append(500);
        list.append(600);

        list.add(3, 250);
        list.add(1, 50);
        list.add(0, 10);

        list.append(700);
        list.remove(1);
        list.removeItem(600);
    }

}
