package list.arraylist;

import list.ListInterface;

public class MyArrayList<E> implements ListInterface<E> {

    private E item[];
    private int numItems;
    private static final int DEFAULT_CAPACITY = 64;
    private static final int NOT_FOUND = -12345;

    public MyArrayList() {
        item = (E[]) new Object[DEFAULT_CAPACITY];
        numItems = 0;
    }

    public MyArrayList(int n) {
        item = (E[]) new Object[n];
        numItems = 0;
    }

    @Override
    public void add(int index, E x) {
        if (numItems >= item.length || index < 0 || index > numItems) {
            System.out.println("에러처리");
        }
        else {
            for (int i = numItems - 1; i >= index; i--) {
                item[i + 1] = item[i];
                item[index] = x;
                numItems++;
            }
        }
    }

    @Override
    public void append(E x) {
        if (numItems >= item.length){
            System.out.println("에러처리");
        }
        else {
            item[numItems++] = x;
        }
    }

    @Override
    public E remove(int index) {
        if (isEmpty() || index < 0 || index > numItems - 1) {
            return null;
        }else {
            E tmp = item[index];
            for (int i = index; i <= numItems - 2; i++) {
                item[i] = item[i + 1];
            }
            numItems--;
            return tmp;
        }
    }

    @Override
    public boolean removeItem(E x) {
        //위치 찾기
        int k = 0;
        while (k < numItems && ((Comparable) item[k]).compareTo(x) != 0) {
            k++;
        }
        if (k == numItems) {
            return false;
        }
        //삭제하고 쉬프트
        else{
            for (int i = k; i <= numItems - 2; i++) {
                item[i] = item[i + 1];
            }
            numItems--;
            return true;
        }
    }

    @Override
    public E get(int i) {
        if (i >= 0 && i <= numItems - 1) {
            return item[i];
        }
        return null;
    }

    @Override
    public void set(int i, E x) {
        if (i >= 0 && i <= numItems - 1) {
            item[i] = x;
        }else {
            System.out.println("에러처리");
        }
    }

    @Override
    public int indexOf(E x) {
        for (int i = 0; i < numItems; i++) {
            if (((Comparable) item[i]).compareTo(x) == 0) {
                return i;
            }
        }

        return NOT_FOUND;
    }

    @Override
    public int len() {
        return numItems;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public void clear() {
        item = (E[]) new Object[item.length];
        numItems = 0;
    }
}
