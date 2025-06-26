package list;

public interface ListInterface<E> {

    void insertElement(int i, E x); // 지정 위치에 저장
    void addElement(E x); //맨 뒤에 저장
    E removeElement(int i); // 인덱스 위치 데이터를 삭제
    E getElement(int i); // 인덱스 위치 데이터 반환
    int getSize(); // 사이즈
    boolean isEmpty(); // 비어있으면 true
    void removeAll();
    void printAll();

}
