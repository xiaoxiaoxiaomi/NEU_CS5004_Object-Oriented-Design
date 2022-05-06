package problem2;

/**
 * Represents an empty BagOfWords
 */
public class EmptyBag implements BagOfWords {

  private static final Integer HASH_CODE = 123;

  /**
   * Checks if the BagOfWords is empty
   *
   * @return true
   */
  @Override
  public Boolean isEmpty() {
    return true;
  }

  /**
   * Returns the number of elements in the BagOfWords, duplicates will be counted as separate
   * elements
   *
   * @return 0
   */
  @Override
  public Integer size() {
    return 0;
  }

  /**
   * Returns a new BagOfWords that contains all elements in the original BagOfWords plus s
   *
   * @param s - a string
   * @return a new BagOfWords that contains all elements in the original BagOfWords plus s
   */
  @Override
  public BagOfWords add(String s) {
    return new ConsBag(s, this);
  }

  /**
   * Checks if s is in the BagOfWords
   *
   * @param s - a string
   * @return false
   */
  @Override
  public Boolean contains(String s) {
    return false;
  }

  /**
   * Remove s if s in the BagOfWords
   *
   * @param s - a string
   * @return this BagOfWords
   */
  @Override
  public BagOfWords remove(String s) {
    return this;
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
    return obj instanceof EmptyBag;
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return EmptyBag.HASH_CODE;
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "EmptyBag{}";
  }
}
