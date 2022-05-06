package problem2;

import java.util.Arrays;
import java.util.Objects;

/**
 * Queue is a data collection that operates in a FIFO (first in, first out) manner.
 */
public class Queue implements QueueInterface {

  private Integer queue[];

  /**
   * Default constructor for Queue
   */
  public Queue() {
    this.queue = new Integer[0];
  }

  /**
   * Constructor for Queue using an array as input
   *
   * @param queue - an array to initialize queue
   */
  public Queue(Integer[] queue) {
    this.queue = queue;
  }

  /**
   * Creates and returns an empty Queue.
   *
   * @return an empty Queue.
   */
  @Override
  public Queue emptyQueue() {
    return new Queue();
  }

  /**
   * Checks if the Queue is empty. Returns true if the Queue contains no items, false otherwise.
   *
   * @return true if the Queue contains no items, false otherwise.
   */
  @Override
  public Boolean isEmpty() {
    return this.queue.length == 0;
  }

  /**
   * Adds the given Integer to the end of the Queue (note: queue allows duplicates).
   *
   * @param n - given Integer
   * @return - queue after adding the given Integer to the end of the Queue
   */
  @Override
  public Queue add(Integer n) {
    Integer[] newQueue = new Integer[this.queue.length + 1];
    System.arraycopy(this.queue, 0, newQueue, 0, this.queue.length);
    newQueue[this.queue.length] = n;
    return new Queue(newQueue);
  }

  /**
   * Returns true if the given Integer is in the Queue, false otherwise.
   *
   * @param n - given Integer
   * @return true if the given Integer is in the Queue, false otherwise.
   */
  @Override
  public Boolean contains(Integer n) {
    for (Integer integer : this.queue) {
      if (Objects.equals(integer, n)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns a copy of the Queue with the first element removed.
   *
   * @return a copy of the Queue with the first element removed.
   */
  @Override
  public Queue remove() {
    if (this.isEmpty()) {
      throw new RuntimeException("Can not remove from an empty queue");
    }
    return new Queue(Arrays.copyOfRange(this.queue, 1, this.queue.length));
  }

  /**
   * Returns a copy of the Queue with the given Integer removed. If the given Integer is not in the
   * Queue, returns the Queue as is.
   *
   * @param n - given Integer
   * @return a copy of the Queue with the given Integer removed. If the given Integer is not in the
   * Queue, returns the Queue as is.
   */
  @Override
  public Queue removeElement(Integer n) {
    Integer[] newQueue = new Integer[this.queue.length];
    int newInd = 0;
    int count = 0;
    for (Integer integer : this.queue) {
      if (!Objects.equals(integer, n)) {
        newQueue[newInd++] = integer;
      } else {
        count++;
      }
    }
    return new Queue(Arrays.copyOfRange(newQueue, 0, this.queue.length - count));
  }

  /**
   * Gets the number of items in the Queue.
   *
   * @return the number of items in the Queue.
   */
  @Override
  public Integer size() {
    return this.queue.length;
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
    Queue queue1 = (Queue) o;
    return Arrays.equals(queue, queue1.queue);
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Arrays.hashCode(queue);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "Queue{" +
        "queue=" + Arrays.toString(queue) +
        '}';
  }
}
