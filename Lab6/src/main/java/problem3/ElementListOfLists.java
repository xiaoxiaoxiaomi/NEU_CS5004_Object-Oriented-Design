package problem3;

public class ElementListOfLists extends AbstractListOfLists {

  private ILinkedList listElement;
  private ListOfLists pointerToRest;

  public ElementListOfLists(ILinkedList listElement, ListOfLists pointerToRest) {
    this.listElement = listElement;
    this.pointerToRest = pointerToRest;
  }

  public ElementListOfLists(ILinkedList listElement) {
    this.listElement = listElement;
    this.pointerToRest = new EmptyListOfLists();
  }

  public ILinkedList getListElement() {
    return listElement;
  }

  public ListOfLists getPointerToRest() {
    return pointerToRest;
  }

  @Override
  public Integer size() {
    return 1 + this.pointerToRest.size();
  }

  @Override
  public Integer length() {
    return this.listElement.count() + this.pointerToRest.length();
  }

  @Override
  public Integer sum() {
    return this.listElement.sumElements() + this.pointerToRest.sum();
  }

  @Override
  public Boolean isEmpty() {
    return Boolean.FALSE;
  }

  @Override
  public ListOfLists removeInteger(Integer element) {
    if (this.listElement.contains(element)) {
      return new ElementListOfLists(this.listElement.remove(element), this.pointerToRest);
    } else {
      return new ElementListOfLists(this.listElement, this.pointerToRest.removeInteger(element));
    }
  }

  @Override
  public ListOfLists removeAllIntegers(Integer element) {
    if (this.listElement.contains(element)) {
      return new ElementListOfLists(this.listElement.remove(element),
          this.pointerToRest.removeAllIntegers(element));
    } else {
      return new ElementListOfLists(this.listElement,
          this.pointerToRest.removeAllIntegers(element));
    }
  }
}
