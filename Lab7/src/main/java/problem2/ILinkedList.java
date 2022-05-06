package problem2;

public interface ILinkedList<T> {

  Integer count();

  T getItem();

  ILinkedList<T> getRest();

  ILinkedList<T> insert(T item);

  ILinkedList<T> insertAt(T item, Integer index) throws IndexOutOfBoundsException;

  Boolean contains(T item);

  ILinkedList<T> remove(T item);
}
