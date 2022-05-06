package problem2;

public class EmptyNode<T> implements ILinkedList<T> {

  public EmptyNode() {
  }

  @Override
  public Integer count() {
    return 0;
  }

  @Override
  public T getItem() {
    return null;
  }

  @Override
  public ILinkedList<T> getRest() {
    return null;
  }

  @Override
  public ILinkedList<T> insert(T item) {
    return new ElementNode<>(item, this);
  }

  @Override
  public ILinkedList<T> insertAt(T item, Integer index) {
    if (!index.equals(0)) {
      throw new IndexOutOfBoundsException();
    } else {
      return new ElementNode<>(item, this);
    }
  }

  @Override
  public Boolean contains(T item) {
    return false;
  }

  @Override
  public ILinkedList<T> remove(T item) {
    return this;
  }

  @Override
  public int hashCode() {
    return 31;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    return obj != null && getClass() == obj.getClass();
  }

  @Override
  public String toString() {
    return "EmptyNode";
  }
}
