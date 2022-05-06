package problem2;

/**
 * Represents a Cartesian coordinate.
 */
public class Posn {

  private Integer x;
  private Integer y;

  public Posn(Integer x, Integer y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Getter for property 'x'.
   *
   * @return Value for property 'x'.
   */
  public Integer getX() {
    return this.x;
  }

  /**
   * Getter for property 'y'.
   *
   * @return Value for property 'y'.
   */
  public Integer getY() {
    return this.y;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Posn posn = (Posn) o;
    if (this.x != null ? !this.x.equals(posn.x) : posn.x != null) {
      return false;
    }
    return this.y != null ? this.y.equals(posn.y) : posn.y == null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    int result = this.x != null ? this.x.hashCode() : 0;
    result = 31 * result + (this.y != null ? this.y.hashCode() : 0);
    return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Posn{" +
        "x=" + x +
        ", y=" + y +
        '}';
  }
}
