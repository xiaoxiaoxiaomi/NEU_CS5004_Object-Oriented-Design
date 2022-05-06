package problem2;

/**
 * This is an interface for Queue
 */
public interface QueueInterface {

  /**
   * Creates and returns an empty Queue.
   *
   * @return an empty Queue.
   */
  Queue emptyQueue();

  /**
   * Checks if the Queue is empty. Returns true if the Queue contains no items, false otherwise.
   *
   * @return true if the Queue contains no items, false otherwise.
   */
  Boolean isEmpty();

  /**
   * Adds the given Integer to the end of the Queue (note: queue allows duplicates).
   *
   * @param n - given Integer
   * @return - queue after adding the given Integer to the end of the Queue
   */
  Queue add(Integer n);

  /**
   * Returns true if the given Integer is in the Queue, false otherwise.
   *
   * @param n - given Integer
   * @return true if the given Integer is in the Queue, false otherwise.
   */
  Boolean contains(Integer n);

  /**
   * Returns a copy of the Queue with the first element removed.
   *
   * @return a copy of the Queue with the first element removed.
   */
  Queue remove();

  /**
   * Returns a copy of the Queue with the given Integer removed. If the given Integer is not in the
   * Queue, returns the Queue as is.
   *
   * @param n - given Integer
   * @return a copy of the Queue with the given Integer removed. If the given Integer is not in the
   * Queue, returns the Queue as is.
   */
  Queue removeElement(Integer n);

  /**
   * Gets the number of items in the Queue.
   *
   * @return the number of items in the Queue.
   */
  Integer size();
}
