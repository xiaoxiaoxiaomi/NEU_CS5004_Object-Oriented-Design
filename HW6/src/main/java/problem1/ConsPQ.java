package problem1;

import java.util.Objects;

/**
 * Represents a non-empty priority queue
 */
public class ConsPQ implements PriorityQueue {

  private final Integer priority;
  private final String value;
  private final PriorityQueue priorityQueue;

  /**
   * Constructor of PriorityQueue
   *
   * @param priority      - a priority, encoded as an Integer
   * @param value         - a value associated with the priority, in our case the value will be a
   *                      String
   * @param priorityQueue - an existing priority queue
   */
  public ConsPQ(Integer priority, String value, PriorityQueue priorityQueue) {
    this.priority = priority;
    this.value = value;
    this.priorityQueue = priorityQueue;
  }

  /**
   * Checks if PQ is empty
   *
   * @return false
   */
  @Override
  public Boolean isEmpty() {
    return false;
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
    if (priority < this.priority) {
      return new ConsPQ(priority, value, this);
    } else {
      return new ConsPQ(this.priority, this.value, this.priorityQueue.add(priority, value));
    }
  }

  /**
   * Returns the value in the PQ that has the highest priority, only return one value when multiple
   * elements have the highest priority
   *
   * @return the value in the PQ that has the highest priority
   */
  @Override
  public String peek() {
    if (this.priorityQueue.isEmpty()) {
      return this.value;
    } else {
      return this.priorityQueue.peek();
    }
  }

  /**
   * Returns a copy of the PQ without the element with the highest priority, only remove one element
   * when multiple elements have the highest priority
   *
   * @return a copy of the PQ without the element with the highest priority
   */
  @Override
  public PriorityQueue pop() {
    if (this.priorityQueue.isEmpty()) {
      return new EmptyPQ();
    } else {
      return new ConsPQ(this.priority, this.value, this.priorityQueue.pop());
    }
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param o - the reference object with which to compare.
   * @return true if this object is the same as the obj argument; false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConsPQ consPQ = (ConsPQ) o;
    return Objects.equals(priority, consPQ.priority) && Objects.equals(value,
        consPQ.value) && Objects.equals(priorityQueue, consPQ.priorityQueue);
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(priority, value, priorityQueue);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "ConsPQ{" +
        "priority=" + priority +
        ", value='" + value + '\'' +
        ", priorityQueue=" + priorityQueue +
        '}';
  }
}
