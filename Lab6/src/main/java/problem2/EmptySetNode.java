package problem2;

public class EmptySetNode extends AbstractSet {

  protected EmptySetNode() {
  }

  @Override
  public Boolean isEmpty() {
    return Boolean.TRUE;
  }



  @Override
  public Boolean contains(Integer element) {
    return Boolean.FALSE;
  }

  @Override
  public Set remove(Integer element) {
    throw new IllegalArgumentException("The given element cannot be removed!");
  }

  @Override
  public Integer size() {
    return 0;
  }
}
