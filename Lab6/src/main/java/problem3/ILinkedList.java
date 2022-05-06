package problem3;

/**
 * Required operations for a linked list of Integers
 */
public interface ILinkedList {

  /**
   * Gets the number of elements in the list.
   *
   * @return THe number of elements in the list.
   */
  Integer count();

  /**
   * Get the item at the head of the list.
   *
   * @return The integer at the head of the list or null if the list is empty.
   */
  Integer getItem();

  /**
   * Get the rest of the list.
   *
   * @return The rest of the list or null if the list is empty.
   */
  ILinkedList getRest();

  /**
   * Inserts an element at the head of the list.
   *
   * @param item The item to insert.
   * @return The linked list with the new item at the head.
   */
  ILinkedList insert(Integer item);


  /**
   * Inserts an element at the specified index.
   *
   * @param item  The item to insert.
   * @param index The index to insert at.
   * @return The linked list with the new item inserted.
   * @throws IndexOutOfBoundsException If the specified index is out of bounds.
   */
  ILinkedList insertAt(Integer item, Integer index) throws IndexOutOfBoundsException;

  Integer sumElements();

  Boolean contains(Integer element);

  ILinkedList remove(Integer element);
}
