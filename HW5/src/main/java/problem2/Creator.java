package problem2;

/**
 * Abstract class creator
 */
public abstract class Creator {

  /**
   * Default constructor for class Creator
   */
  public Creator() {
  }

  /**
   * Judge if item's creator contains the artist
   * @param artist - artist, encoded as RecordingArtist
   * @return true if item's creator contains the artist, otherwise return false
   */
  public abstract Boolean containsArtist(RecordingArtist artist);
}
