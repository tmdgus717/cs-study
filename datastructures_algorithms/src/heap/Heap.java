package heap;

public class Heap<E extends Comparable> implements PQInterface<E> {
    //파라미터 타임 E 는 인터페이스 Comparable 만족해야한다는 뜻

    private E[] A; //모든 배열은 완전 이진 트리로 간주할 수 있다
    private int numItems;

    public Heap(int arraySize) {
        // E는 Comparable을 구현하니까, Comparable 배열을 만들고 캐스팅
        A = (E[]) new Comparable[arraySize];
        numItems = 0;
    }

    public Heap(E[] B, int numElements) {
        A = B;
        numItems = numElements;
    }

    @Override
    public void insert(E newItem) throws PQException {
        //재귀 버전
        if (numItems < A.length) {
            A[numItems] = newItem;
            percolateUp(numItems);
            numItems++;
        }else {
            throw new PQException("HeapERR : Insert()-Overflow!");
        }
    }

    //중요 - 스며오르기
    private void percolateUp(int index) {
        int parent = (index - 1) / 2; //완전 이진 탐색에서 부모를 찾는 공식
        if (parent >= 0 && A[index].compareTo(A[parent]) > 0) {
            E tmp = A[index];
            A[index] = A[parent];
            A[parent] = tmp;
            percolateUp(parent); //부모 위치에서 다시 비교 시작
        }
    }

    @Override
    public E deleteMax() throws PQException {
        if (!isEmpty()){
            E max = A[0];
            A[0] = A[numItems - 1]; // 마지막 값을 최상단으로 올린다음 수선
            percolateDown(0);
            numItems--;
            return max;
        }
        else {
            throw new PQException("HeapErr: DeleteMax()-Underflow");
        }
    }

    private void percolateDown(int index) {
        int leftChild = 2 * index + 1; //완전 이진 탐색에서 자식을 구하는 공식
        int rightChild = 2 * index + 2;
        int child = leftChild;
        if(child <= numItems - 1){ //자식이 있다면
            //두 번째 자식도 있다면 자식들 중 큰 값과 비교
            if (rightChild <= numItems - 1 && A[child].compareTo(A[rightChild]) < 0) {
                child = rightChild;
            }
            //자식이 root 보다 크다면
            if (A[index].compareTo(A[child]) < 0) {
                E tmp = A[index];
                A[index] = A[child];
                A[child] = tmp;
                percolateDown(child); //자식을 아래 값과 또 비교
            }
        }
    }

    @Override
    public E max() throws PQException { //힙의 최대값
        if (!isEmpty()) {
            return A[0];
        }
        else {
            throw new PQException("HeapErr: Max()-Empty!");
        }
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public void clear() {
        A = (E[]) new Comparable[A.length];
        numItems = 0;
    }
}
