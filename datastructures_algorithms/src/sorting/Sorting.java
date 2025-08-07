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
        //분할정복 원리 사용
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

    public void heapSort() {
        buildHeap();
        int tmp;
        for (int i = array.length - 1; i >= 1; i--) {
            tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;
            percolateDown(0, i - 1);
        }
    }

    //A[0] 은 루트 노드
    //수선은 맨 마지막 노드의 부모로부터 시작 -> 이 노드를 루트로하는 서브 트리를 힙으로 수선 : 반복
    private void buildHeap() { //배열을 정렬하기 전 힙 특성을 만족하도록 변경
        if (array.length >= 2) { // 완전 이진 트리 구조이므로 값이 2 이상
            int lastNodeIndex = array.length - 1;
            for (int i = (lastNodeIndex - 1) / 2; i >= 0; i--) { //마지막 노드의 부모노드 부터 시작 (3..2..1..0)
                percolateDown(i, array.length - 1); //현재 위치와 배열 사이즈
            }
        }
    }

    /* 힙 : 완전 이진 트리 구조를 사용하는 우선순위 큐
     * A[k] 의 자식은 A[2k+1]과 A[2k+2]
     * A[0] 의 자식은 A[1]과 A[2]
     * A[1] 의 자식은 A[3]과 A[4]
     * A[k] 의 부모 노드는 A[(k - 1) / 2]
     * */
    private void percolateDown(int i, int n) {//최대 힙
        int child = 2 * i + 1; //left
        int rightChild = 2 * i + 2; //right
        if (child <= n) { //  자식 노드의 인덱스가 현재 힙 크기(n) 안에 있는지 확인
            if ((rightChild <= n) && (array[child] < array[rightChild])){
                child = rightChild; // 더 큰 자식과 교환이 이루어진다.
            }
            if (array[i] < array[child]) { //부모노드의 값이 더 작다면 교환
                int tmp = array[i];
                array[i] = array[child];
                array[child] = tmp;
                percolateDown(child, n); //종료될때까지 반복
            }
        }
    }

    public void shellSort() {
        for (int h = array.length / 7; h > 5; h = h / 5 - 1) {
            for (int k = 0; k <= h - 1; k++) {
                stepInsertionSort(k, h);
            }
        }
        stepInsertionSort(0, 1);
    }

    private void stepInsertionSort(int k, int h) {
        int j, insItem;
        for (int i = k + h; i <= array.length - 1; i += h) {
            insItem = array[i];
            for (j = i - h; j >= 0 && array[j] > insItem; j -= h) {
                array[j + h] = array[j];
            }
            array[j + h] = insItem;
        }
    }

    //계수 정렬
    public int[] countingSort(int k) { // 0 ~ k-1
        int[] cnt = new int[k];
        //카운팅 배열 초기화
        for (int i = 0; i < k; i++) {
            cnt[i] = 0;
        }
        //숫자 카운팅
        for (int i = 0; i < array.length; i++) {
            cnt[array[i]]++;
        }
        cnt[0]--;//인덱스 조정
        //누적합 -> 순서를 보장해 주기 위해서 (STABLE SORT)
        for (int i = 1; i < k; i++) {
            cnt[i] += cnt[i - 1];
        }
        int[] tmp = new int[array.length];
        //뒤에서부터 값을 읽어오면서 누적합 배열의 인덱스도 하나씩 줄여서 조정해준다
        for (int j = array.length - 1; j >= 0; j--) {
            tmp[cnt[array[j]]] = array[j];
            cnt[array[j]]--;
        }
        return tmp;
    }

    //기수 정렬
    public void radixSort() {
        int[] cnt = new int[10];
        int[] start = new int[10];
        int[] tmp = new int[array.length];
        int max = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        //최대값으로 자릿수 계산
        int numDigits = (int)Math.log10(max) + 1;
        for (int digit = 1; digit <= numDigits; digit++) { //자릿수를 뒤에서부터 하나씩 올려가면서 계산
            for (int d = 0; d <= 9; d++) {
                cnt[d] = 0; //배열 초기화
            }
            for (int i = 0; i < array.length; i++) {
                cnt[(int)(array[i]/Math.pow(10, digit-1)) % 10] ++;
            }
            start[0] = 0;
            for (int d = 1; d <= 9; d++) {
                start[d] = start[d - 1] + cnt[d - 1];
            }
            for (int i = 0; i < array.length; i++) {
                tmp[start[(int) (array[i] / Math.pow(10, digit - 1)) % 10]++] = array[i];
            }
            for (int i = 0; i < array.length; i++) {
                array[i] = tmp[i];
            }
        }
    }
}
