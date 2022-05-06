package problem2;

/**
 * Represents an immutable BagOfWords. A BagOfWords is a data container, holding Strings (words). A
 * BagOfWords can contain duplicates, and Strings (words) have no order.
 */
public interface BagOfWords {

  /**
   * Creates and returns an empty BagOfWords
   *
   * @return an empty BagOfWords
   */
  static BagOfWords emptyBagOfWords() {
    return new EmptyBag();
  }

  /**
   * Checks if the BagOfWords is empty
   *
   * @return true if the BagOfWords contains no items, false otherwise.
   */
  Boolean isEmpty();

  /**
   * Returns the number of elements in the BagOfWords, duplicates will be counted as separate
   * elements
   *
   * @return the number of elements in the BagOfWords
   */
  Integer size();

  /**
   * Returns a new BagOfWords that contains all elements in the original BagOfWords plus s
   *
   * @param s - a string
   * @return a new BagOfWords that contains all elements in the original BagOfWords plus s
   */
  BagOfWords add(String s);

  /**
   * Checks if s is in the BagOfWords
   *
   * @param s - a string
   * @return true if the BagOfWords contains s and false otherwise
   */
  Boolean contains(String s);

  /**
   * Remove s if s in the BagOfWords
   *
   * @param s - a string
   * @return a new BagOfWords after removing s
   */
  BagOfWords remove(String s);
}
