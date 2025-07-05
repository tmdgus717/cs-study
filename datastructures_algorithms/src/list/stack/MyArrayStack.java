package list.stack;


import list.MyArrayList;

public class MyArrayStack<E> extends MyArrayList<E> implements StackInterface<E> {

    int top;

    public MyArrayStack() {
        this.top = 0;
    }

    public MyArrayStack(int size) {
        super(size);
    }

    @Override
    public void push(E data) {
        if (isFull()) {
            System.out.println("stack is full");
            return;
        }

        addElement(data);
        top++;
    }

    @Override
    public E pop() {
        if (top == 0){
            System.out.println("stack is empty");
            return null;
        }

        return removeElement(--top);
    }

    @Override
    public E peek() {
        if (top == 0){
            System.out.println("stack is empty");
            return null;
        }

        return getElement(top-1);
    }

    @Override
    public void peekAll() {
        printAll();
    }

    public boolean isEmpty()
    {
        if (top == 0){
            return true;
        }
        else return false;
    }

    public boolean isFull()
    {
        if(top == getCapacity()){
            return true;
        }
        else return false;
    }

}
