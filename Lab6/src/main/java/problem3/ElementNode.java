package problem3;

import java.util.Objects;

public class ElementNode implements ILinkedList {

  private Integer item;
  private ILinkedList rest;

  public ElementNode(Integer item, ILinkedList rest) {
    this.item = item;
    this.rest = rest;
  }

  /**
   * Gets the number of elements in the list.
   *
   * @return THe number of elements in the list.
   */
  @Override
  public Integer count() {

    return 1 + this.rest.count();
    //return 1 + 1 + this.rest.count();
    //return 1 + 1 + 1 + this.rest.count();
    //
    //
    // return 1 + 1 + 1 + ....+ 0
  }

  /**
   * Get the item at the head of the list.
   *
   * @return The integer at the head of the list or null if the list is empty.
   */
  @Override
  public Integer getItem() {
    return this.item;
  }

  /**
   * Get the rest of the list.
   *
   * @return The rest of the list or null if the list is empty.
   */
  @Override
  public ILinkedList getRest() {
    return this.rest;
  }

  /**
   * Inserts an element at the head of the list.
   *
   * @param item The item to insert.
   * @return The linked list with the new item at the head.
   */
  @Override
  public ILinkedList insert(Integer item) {

    return new ElementNode(item, this);
  }

  /**
   * Inserts an element at the specified index.
   *
   * @param item  The item to insert.
   * @param index The index to insert at.
   * @return The linked list with the new item inserted.
   */
  @Override
  public ILinkedList insertAt(Integer item, Integer index) {
    if (index.equals(0)) {
      ILinkedList thisCopy = new ElementNode(this.item, this.rest);
      return new ElementNode(item, thisCopy);
    } else {
      return new ElementNode(this.item, this.rest.insertAt(item, index - 1));
    }
  }

  @Override
  public Integer sumElements() {
    return this.item + this.rest.sumElements();
  }

  @Override
  public Boolean contains(Integer element) {
    if (this.item.equals(element)) {
      return Boolean.TRUE;
    } else {
      return this.rest.contains(element);
    }
  }

  @Override
  public ILinkedList remove(Integer element) {
    if (!this.contains(element)) {
      return this;
    } else if (this.item.equals(element)) {
      return this.rest;
    } else {
      return new ElementNode(this.item, this.rest.remove(element));
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
    ElementNode that = (ElementNode) o;
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
