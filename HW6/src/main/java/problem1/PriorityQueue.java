package problem1;

/**
 * Represents an immutable Priority Queue
 */
public interface PriorityQueue {

  /**
   * Creates and returns an empty PQ
   *
   * @return an empty PQ
   */
  static PriorityQueue createEmpty() {
    return new EmptyPQ();
  }

  /**
   * Checks if PQ is empty
   *
   * @return true if the PQ contains no items, false otherwise
   */
  Boolean isEmpty();

  /**
   * Adds the given element (the priority and its associated value) to the PQ
   *
   * @param priority - a priority, encoded as an Integer
   * @param value    - a value associated with the priority, in our case the value will be a String
   * @return a copy of the PQ with the given element
   */
  PriorityQueue add(Integer priority, String value);

  /**
   * Returns the value in the PQ that has the highest priority, only return one value when multiple
   * elements have the highest priority
   *
   * @return the value in the PQ that has the highest priority
   */
  String peek();

  /**
   * Returns a copy of the PQ without the element with the highest priority, only remove one element
   * when multiple elements have the highest priority
   *
   * @return a copy of the PQ without the element with the highest priority
   */
  PriorityQueue pop();
}
