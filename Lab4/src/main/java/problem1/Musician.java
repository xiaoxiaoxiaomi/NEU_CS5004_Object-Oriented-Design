package problem1;

import java.util.Objects;

public class Musician extends AbstractArtist{
  private String recordingCompany;
  private String lastRecordAlbum;

  public Musician(Name artistName, Integer age, String[] genres, String[] award,
      String recordingCompany, String lastRecordAlbum) {
    super(artistName, age, genres, award);
    this.recordingCompany = recordingCompany;
    this.lastRecordAlbum = lastRecordAlbum;
  }

  public String getRecordingCompany() {
    return recordingCompany;
  }

  public String getLastRecordAlbum() {
    return lastRecordAlbum;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Musician musician = (Musician) o;
    return Objects.equals(recordingCompany, musician.recordingCompany)
        && Objects.equals(lastRecordAlbum, musician.lastRecordAlbum);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), recordingCompany, lastRecordAlbum);
  }

  @Override
  public String toString() {
    return "Musician{" +
        "recordingCompany='" + recordingCompany + '\'' +
        ", lastRecordAlbum='" + lastRecordAlbum + '\'' +
        '}';
  }
}
