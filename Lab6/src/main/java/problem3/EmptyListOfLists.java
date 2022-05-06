package problem3;

public class EmptyListOfLists extends AbstractListOfLists {

  public EmptyListOfLists() {
  }

  @Override
  public Integer size() {
    return 0;
  }

  @Override
  public Integer length() {
    return 0;
  }

  @Override
  public Integer sum() {
    return 0;
  }

  @Override
  public Boolean isEmpty() {
    return Boolean.TRUE;
  }

  @Override
  public ListOfLists removeInteger(Integer element) {
    return this;
  }

  @Override
  public ListOfLists removeAllIntegers(Integer element) {
    return this;
  }
}
