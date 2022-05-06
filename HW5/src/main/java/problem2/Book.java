package problem2;

/**
 * Class Book inherits Item which has an Author as its creator.
 */
public class Book extends Item {

  /**
   * Constructor for class Book
   *
   * @param author - author, encoded as Author
   * @param title  - title, encoded as String
   * @param year   - year, encoded as Integer
   */
  public Book(Author author, String title, Integer year) {
    super(author, title, year);
  }
}
