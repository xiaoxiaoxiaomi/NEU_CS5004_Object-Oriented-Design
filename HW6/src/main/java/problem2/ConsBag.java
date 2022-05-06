package problem2;

import java.util.Objects;

/**
 * Represents an non-empty BagOfWords
 */
public class ConsBag implements BagOfWords {

  private String s;
  private BagOfWords bagOfWords;

  /**
   * Constructor of BagOfWords
   *
   * @param s          - a string
   * @param bagOfWords - an existing BagOfWords
   */
  public ConsBag(String s, BagOfWords bagOfWords) {
    this.s = s;
    this.bagOfWords = bagOfWords;
  }

  /**
   * Checks if the BagOfWords is empty
   *
   * @return false
   */
  @Override
  public Boolean isEmpty() {
    return false;
  }

  /**
   * Returns the number of elements in the BagOfWords, duplicates will be counted as separate
   * elements
   *
   * @return the number of elements in the BagOfWords
   */
  @Override
  public Integer size() {
    return 1 + this.bagOfWords.size();
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
   * @return true if the BagOfWords contains s and false otherwise
   */
  @Override
  public Boolean contains(String s) {
    if (s.equals(this.s)) {
      return true;
    } else {
      return this.bagOfWords.contains(s);
    }
  }

  /**
   * Remove s if s in the BagOfWords
   *
   * @param s - a string
   * @return a new BagOfWords after removing s
   */
  @Override
  public BagOfWords remove(String s) {
    if (!contains(s)) {
      return this;
    }
    if (s.equals(this.s)) {
      return this.bagOfWords;
    } else {
      return new ConsBag(this.s, this.bagOfWords.remove(s));
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
    ConsBag consBag = (ConsBag) o;
    if (!this.size().equals(consBag.size())) {
      return false;
    }
    if (!consBag.contains(this.s)) {
      return false;
    }
    return this.bagOfWords.equals(consBag.remove(this.s));
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(s, bagOfWords);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "ConsBag{" +
        "s='" + s + '\'' +
        ", bagOfWords=" + bagOfWords +
        '}';
  }
}
