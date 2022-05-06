package problem2;

/**
 * Class Author inherits Individual and stores first name and last name
 */
public class Author extends Individual {

  /**
   * Constructor for class Author
   *
   * @param firstName - first name, encoded as String
   * @param lastName  - last name, encoded as String
   */
  public Author(String firstName, String lastName) {
    super(firstName, lastName);
  }

  /**
   * It will always return false because Author won't be artist
   * @param artist - artist, encoded as RecordingArtist
   * @return false
   */
  @Override
  public Boolean containsArtist(RecordingArtist artist) {
    return false;
  }
}
