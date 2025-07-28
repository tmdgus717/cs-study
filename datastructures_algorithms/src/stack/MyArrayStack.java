package stack;

public class MyArrayStack<E> implements MyStack<E>{

    private E stack[];
    private int topIndex;
    private static final int DEFAULT_CAPACITY = 64;
    private final E ERROR = null;

    public MyArrayStack() {
        stack = (E[]) new Object[DEFAULT_CAPACITY];
        topIndex = -1; //topIndex 초기값
    }

    public MyArrayStack(int size) {
        stack = (E[]) new Object[size];
        this.topIndex = -1;
    }

    @Override
    public void push(E item) {
        if(isFull()){
            System.out.println("에러 처리");
        }else {
            topIndex++;
            stack[topIndex] = item;
        }
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return ERROR;
        }else {
            var item = stack[topIndex];
            topIndex--;
            return item;
        }
    }

    @Override
    public E top() {
        if (isEmpty()) return ERROR;
        else{
            return stack[topIndex];
        }
    }

    @Override
    public boolean isEmpty() {
        return topIndex < 0;
    }

    @Override
    public void popAll() {
        stack = (E[]) new Object[stack.length]; //이전에 사용한 값들을 가비지 컬렉터에 대상이 되도록 해주는 코드
        topIndex = -1;
    }

    public boolean isFull() {
        return (topIndex == stack.length - 1);
    }
}
