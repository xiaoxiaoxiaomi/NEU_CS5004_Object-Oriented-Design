package problem2;

/**
 * Class Music inherits Item which can have either a RecordingArtist or a Band as its creator.
 */
public class Music extends Item {

  /**
   * Constructor for class Music
   *
   * @param recordingArtist - recording artist, encoded as RecordingArtist
   * @param title           - title, encoded as String
   * @param year            - year, encoded as Integer
   */
  public Music(RecordingArtist recordingArtist, String title, Integer year) {
    super(recordingArtist, title, year);
  }

  /**
   * Constructor for class Music
   *
   * @param band  - band, encoded as Band
   * @param title - title, encoded as String
   * @param year  - year, encoded as Integer
   */
  public Music(Band band, String title, Integer year) {
    super(band, title, year);
  }
}
