package array;

public interface MyList<T> {
    void add(T data);

    int size();

    int hashCode();

    void insert(int position, T data);

    void deleteByPosition(int position);

    void remove();

    boolean isEmpty();

    void show();

    void clear();

    Integer modCount();

    public boolean add(int position, T data);
}
