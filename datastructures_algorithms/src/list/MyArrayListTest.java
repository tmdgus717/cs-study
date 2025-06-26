package list;

public class MyArrayListTest {

    public static void main(String[] args) {

        MyArrayList array = new MyArrayList();
        array.addElement(10);
        array.addElement(20);

        array.addElement(30);
        array.insertElement(1, 50);
        array.printAll();

        System.out.println("===============");
        array.removeElement(1); //50삭제
        array.printAll();
        System.out.println("===============");

        MyArrayList array2 = new MyArrayList();
        array2.addElement(10);
        array2.printAll();
        System.out.println("===============");
        array2.removeElement(1);
        array2.printAll();

        System.out.println(array.getElement(2));

    }
}

