package sorting;

public class SortingTest {
    static final int NUM_SCALE = 100;

    public static void prepare(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (NUM_SCALE * Math.random());
        }
    }
    public static void main(String[] args) {
        int[] array = new int[10];
        prepare(array);
        Sorting s = new Sorting(array);
        System.out.println("정렬 전");
        showArray(array);

//        s.selectionSort();
//        s.bubbleSort();
        s.insertionSort();

        System.out.println("정렬 후");
        showArray(array);
    }

    private static void showArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
