package problem2;

import java.util.HashSet;
import java.util.Objects;

/**
 * Class Band inherits Group and stores a name and a collection of RecordingArtists, the Band’s
 * members
 */
public class Band extends Group {

  private String name;
  private HashSet<RecordingArtist> members;

  /**
   * Constructor for class Band
   *
   * @param name    - name, encoded as String
   * @param members - the Band's members, encoded as a set of RecordingArtists
   */
  public Band(String name, HashSet<RecordingArtist> members) {
    this.name = name;
    this.members = members;
  }

  /**
   * Getter for name
   *
   * @return name, encoded as String
   */
  public String getName() {
    return name;
  }

  /**
   * Getter for the Band's members
   *
   * @return the Band's members, encoded as a set of RecordingArtists
   */
  public HashSet<RecordingArtist> getMembers() {
    return members;
  }

  /**
   * Judge if the band's members contain the artist
   * @param artist - artist, encoded as RecordingArtist
   * @return true if the artist is in the band, otherwise return false
   */
  @Override
  public Boolean containsArtist(RecordingArtist artist) {
    return this.getMembers().contains(artist);
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
    Band band = (Band) o;
    return Objects.equals(name, band.name) && Objects.equals(members,
        band.members);
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, members);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "Band{" +
        "name='" + name + '\'' +
        ", members=" + members +
        '}';
  }
}
