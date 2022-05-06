package problem3;

import java.util.HashMap;

public class EmptyNode implements ILinkedList {

  public EmptyNode() {
  }

  /**
   * Gets the number of elements in the list.
   *
   * @return THe number of elements in the list.
   */
  @Override
  public Integer count() {
    return 0;
  }

  /**
   * Get the item at the head of the list.
   *
   * @return The integer at the head of the list or null if the list is empty.
   */
  @Override
  public Integer getItem() {
    return null;
  }

  /**
   * Get the rest of the list.
   *
   * @return The rest of the list or null if the list is empty.
   */
  @Override
  public ILinkedList getRest() {
    return null;
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
      if (!index.equals(0)) {
          throw new IndexOutOfBoundsException();
      } else {
          return new ElementNode(item, this);
      }
  }

  @Override
  public Integer sumElements() {
    return 0;
  }

  @Override
  public Boolean contains(Integer element) {
    return Boolean.FALSE;
  }

  @Override
  public ILinkedList remove(Integer element) {
    return this;
  }

  /**
   * Returns a hash code value for the object. This method is supported for the benefit of hash
   * tables such as those provided by {@link HashMap}.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return 31; // No fields so we have to make something up!
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param obj the reference object with which to compare.
   * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise.
   */
  @Override
  public boolean equals(Object obj) {
      if (this == obj) {
          return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
          return false;
      }
    return true;
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "EmptyNode";
  }
}
