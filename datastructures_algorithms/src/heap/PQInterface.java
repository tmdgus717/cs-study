package heap;

public interface PQInterface<E> {
    void insert(E newItem) throws PQException;

    E deleteMax() throws PQException;

    E max() throws PQException;

    boolean isEmpty();

    void clear();
}
