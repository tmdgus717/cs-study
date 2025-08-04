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

    private void mSort(int start, int end, int[] tmp) {
        if (start < end) {
            int mid = (start + end) / 2;
            mSort(start, mid, tmp);
            mSort(mid + 1, end, tmp);
            merge(start, mid, end, tmp);
        }
    }

    private void merge(int start, int mid, int end, int[] tmp) {
        //투포인터 원리 사용
        int part1 = start;
        int part2 = mid + 1;
        int index = 0;

        // 두포인터 중 하나가 끝까지 갈때까지 실행
        while (part1 <= mid && part2 <= end) {
            if(array[part1] <= array[part2]){
                tmp[index] = array[part1];
                part1++;
            }else{
                tmp[index] = array[part2];
                part2++;
            }
            index++;
        }

        for (int i = 0; i <= mid - part1; i++) {
            tmp[index + i] = array[part1 + i];
        }
        for (int i = 0; i <= end - part2; i++) {
            tmp[index + i] = array[part2 + i];
        }

        index = 0;
        while (start <= end) {
            array[start++] = tmp[index++];
        }
    }

    public void quickSort() {
        qSort(0, array.length - 1);
    }

    //MergeSort 와는 다르게 먼저 정렬을 하고 분할
    private void qSort(int start, int size) {
        if (start < size) {
            int pivot = partition(start, size);
            qSort(start, pivot - 1);
            qSort(pivot + 1, size);
        }
    }

    private int partition(int start, int size) {
        int pivot = array[size];
        int part1 = start - 1;
        int tmp;
        for (int part2 = start; part2 <= size - 1; part2++) {
            if(array[part2] <= pivot){
                part1++;
                tmp = array[part1];
                array[part1] = array[part2];
                array[part2] = tmp;
            }
        }
        tmp = array[part1 + 1];
        array[part1 + 1] = array[size];
        array[size] = tmp;
        return part1 + 1;
    }
}
