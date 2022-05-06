package problem2;

public abstract class AbstractSet implements Set {

  @Override
  public Set add(Integer element) {
    return new ElementSetNode(element, this);
  }
}
