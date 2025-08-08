package index;

public interface IndexInterface<T> {

    T search(Comparable x);

    void insert(Comparable x);

    void delete(Comparable x);

    boolean isEmpty();

    void clear();

}
