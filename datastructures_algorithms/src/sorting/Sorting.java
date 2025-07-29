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

    public void bubbleSort() {
        int tmp = 0;
        boolean swapped;
        for (int last = array.length - 1; last >= 2; last--) {
            swapped = false;
            for (int i = 0; i <= last - 1; i++) {
                if(array[i] > array[i+1]){
                    //swap
                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    swapped = true;
                }
            }
            //조기종료 조건 : 스왑이 한번도 발생하지 않으면 정렬 완료됨
            if (swapped == false) break;
        }
    }//bubbleSort

    public void insertionSort() {//삽입정렬
        for (int i = 1; i <= array.length - 1; i++) {
            int loc = i - 1;
            int newItem = array[i];
            while (loc >= 0 && newItem < array[loc]){
                array[loc + 1] = array[loc];
                loc--;
            }
            array[loc + 1] = newItem;
        }
    }

}
