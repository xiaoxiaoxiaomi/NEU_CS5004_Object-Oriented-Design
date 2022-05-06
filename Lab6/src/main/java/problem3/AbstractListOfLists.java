package problem3;

public abstract class AbstractListOfLists implements ListOfLists {

  @Override
  public ListOfLists add(ILinkedList list) {
    return new ElementListOfLists(list, this);
  }

}
