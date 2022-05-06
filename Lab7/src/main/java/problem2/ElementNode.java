package problem2;

import java.util.Objects;

public class ElementNode<T> implements ILinkedList<T> {

  private T item;
  private ILinkedList<T> rest;

  public ElementNode(T item, ILinkedList<T> rest) {
    this.item = item;
    this.rest = rest;
  }

  @Override
  public Integer count() {
    return 1 + this.rest.count();
  }

  @Override
  public T getItem() {
    return this.item;
  }

  @Override
  public ILinkedList<T> getRest() {
    return this.rest;
  }

  @Override
  public ILinkedList<T> insert(T item) {
    return new ElementNode<>(item, this);
  }

  @Override
  public ILinkedList<T> insertAt(T item, Integer index) {
    if (index.equals(0)) {
      ILinkedList<T> thisCopy = new ElementNode<>(this.item, this.rest);
      return new ElementNode<>(item, thisCopy);
    } else {
      return new ElementNode<>(this.item, this.rest.insertAt(item, index - 1));
    }
  }

  @Override
  public Boolean contains(T item) {
    if (this.item.equals(item)) {
      return true;
    } else {
      return this.rest.contains(item);
    }
  }

  @Override
  public ILinkedList<T> remove(T item) {
    if (!this.contains(item)) {
      return this;
    } else if (this.item.equals(item)) {
      return this.rest;
    } else {
      return new ElementNode<T>(this.item, this.rest.remove(item));
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ElementNode<?> that = (ElementNode<?>) o;
    return Objects.equals(item, that.item) &&
        Objects.equals(rest, that.rest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(item, rest);
  }

  @Override
  public String toString() {
    return "ElementNode{" +
        "item=" + item +
        ", rest=" + rest +
        '}';
  }
}
