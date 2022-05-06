package problem1;

/**
 * Represents an empty priority queue
 */
public class EmptyPQ implements PriorityQueue {

  private static final int HASH_CODE = 123;

  /**
   * Checks if PQ is empty
   *
   * @return true
   */
  @Override
  public Boolean isEmpty() {
    return true;
  }

  /**
   * Adds the given element (the priority and its associated value) to the PQ
   *
   * @param priority - a priority, encoded as an Integer
   * @param value    - a value associated with the priority, in our case the value will be a String
   * @return a copy of the PQ with the given element
   */
  @Override
  public PriorityQueue add(Integer priority, String value) {
    return new ConsPQ(priority, value, this);
  }

  /**
   *  Throw an exception when calling peek() on an empty PQ
   */
  @Override
  public String peek() {
    throw new IllegalQueueOperationException("Calling peek on an empty PQ");
  }

  /**
   * Throw an exception when calling pop() on an empty PQ
   */
  @Override
  public PriorityQueue pop() {
    throw new IllegalQueueOperationException("Calling pop on an empty PQ");
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param obj - the reference object with which to compare.
   * @return true if this object is the same as the obj argument; false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    return obj instanceof EmptyPQ;
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return EmptyPQ.HASH_CODE;
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "EmptyPQ{}";
  }
}
