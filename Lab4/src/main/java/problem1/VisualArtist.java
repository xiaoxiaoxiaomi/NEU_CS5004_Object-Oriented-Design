package problem1;

import java.util.Arrays;

public abstract class VisualArtist extends AbstractArtist {
  protected String[] exhibits;

  public VisualArtist(Name artistName, Integer age, String[] genres, String[] award,
      String[] exhibits) {
    super(artistName, age, genres, award);
    this.exhibits = exhibits;
  }

  public String[] getExhibits() {
    return exhibits;
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
    VisualArtist that = (VisualArtist) o;
    return Arrays.equals(exhibits, that.exhibits);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + Arrays.hashCode(exhibits);
    return result;
  }

  @Override
  public String toString() {
    return "VisualArtist{" +
        "exhibits=" + Arrays.toString(exhibits) +
        '}';
  }
}
