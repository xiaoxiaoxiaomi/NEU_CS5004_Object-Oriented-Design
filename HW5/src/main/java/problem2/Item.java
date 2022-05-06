package problem2;

import java.util.Objects;

/**
 * Abstract class Item stores information about item: the item’s creator, the item’s title and the
 * year the item was released or published.
 */
public abstract class Item {

  /**
   * The item’s creator, e.g., author, band, recording artist, encoded as Creator
   */
  protected Creator creator;
  /**
   * The item’s title, encoded as String
   */
  protected String title;
  /**
   * The year the item was released or published, encoded as Integer
   */
  protected Integer year;

  /**
   * Constructor of class Item
   *
   * @param creator - the item’s creator, encoded as Creator
   * @param title   - the item’s title, encoded as String
   * @param year    - the year the item was released or published, encoded as Integer
   */
  public Item(Creator creator, String title, Integer year) {
    this.creator = creator;
    this.title = title;
    this.year = year;
  }

  /**
   * Getter for creator
   *
   * @return - the item’s creator, encoded as Creator
   */
  public Creator getCreator() {
    return creator;
  }

  /**
   * Getter for title
   *
   * @return - the item’s title, encoded as String
   */
  public String getTitle() {
    return title;
  }

  /**
   * Getter for year
   *
   * @return - the year the item was released or published, encoded as Integer
   */
  public Integer getYear() {
    return year;
  }

  /**
   * Indicates whether some other item is "equal to" this one.
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
    Item item = (Item) o;
    return Objects.equals(creator, item.creator) && Objects.equals(title,
        item.title) && Objects.equals(year, item.year);
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(creator, title, year);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "Item{" +
        "creator=" + creator +
        ", title='" + title + '\'' +
        ", year='" + year + '\'' +
        '}';
  }
}
