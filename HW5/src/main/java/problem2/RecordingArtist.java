package problem2;

/**
 * Class RecordingArtist inherits Individual and stores first name and last name
 */
public class RecordingArtist extends Individual {

  /**
   * Constructor for class RecordingArtist
   *
   * @param firstName - first name, encoded as String
   * @param lastName  - last name, encoded as String
   */
  public RecordingArtist(String firstName, String lastName) {
    super(firstName, lastName);
  }

  /**
   * Judge if the artist is the given artist
   * @param artist - artist, encoded as RecordingArtist
   * @return true if the artist is the given artist, otherwise return false
   */
  @Override
  public Boolean containsArtist(RecordingArtist artist) {
    return artist.getFirstName() == this.getFirstName()
        && artist.getLastName() == this.getLastName();
  }
}
