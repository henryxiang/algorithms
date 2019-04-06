package algo.collection.list;

public interface List<T> {
    void add(T item);
    void set(int index, T item);
    T get(int index);
    T remove(int index);
    int size();
}
