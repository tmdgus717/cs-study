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
            while (loc >= 0 && newItem < array[loc]){ // 새값이랑 이전 값 비교
                array[loc + 1] = array[loc]; // 한칸씩 뒤로
                loc--;
            }
            array[loc + 1] = newItem; //새 값을 저장
        }
    }

    public void mergeSort() {
        int[] tmp = new int[array.length];
        mSort(0, array.length - 1, tmp);
    }

    private void mSort(int p, int r, int[] tmp) {
        if (p < r) {
            int q = (p + r) / 2;
            mSort(p, q, tmp);
            mSort(q + 1, r, tmp);
            merge(p,q, r, tmp);
        }
    }

    private void merge(int p, int q, int r, int[] tmp) {
        int i = p; int j = q+1;int t = 0;
        while (i <= q && j <= r) {
            if(array[i] <= array[j]){
                tmp[t++] = array[i++];
            }else{
                tmp[t++] = array[j++];
            }
        }

        while (i <= q) { //왼쪽 배열이 남은 경우
            tmp[t++] = array[i++];
        }
        while (j <= r) {
            tmp[t++] = array[j++];
        }
        i = p; t = 0;
        while (i <= r) {
            array[i++] = tmp[t++];
        }
    }
}
