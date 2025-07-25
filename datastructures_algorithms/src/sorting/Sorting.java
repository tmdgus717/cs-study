package sorting;

public class Sorting {
    int[] array;

    public Sorting(int[] array) {
        this.array = array;
    }

    //선택정렬
    public void selectionSort() {
        int k = 0;
        int tmp;
        for (int last = array.length - 1; last >= 1; last--) {
            k = theLargestIndex(last);
            tmp = array[k];
            array[k] = array[last];
            array[last] = tmp;
        }
    }

    private int theLargestIndex(int last) {
        int largestIndex = 0;
        for (int i = 0; i <= last; i++) {
            if(array[i] > array[largestIndex]){
                largestIndex = i;
            }
        }
        return largestIndex;
    }
}
