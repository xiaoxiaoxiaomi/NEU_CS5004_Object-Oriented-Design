package problem2_list;

import java.util.Objects;

public class StrLinkedList implements ListOfStrings {

  private Node listHead;

  public StrLinkedList(Node listHead) {
    this.listHead = listHead;
  }

  public StrLinkedList() {
    this.listHead = null;
  }

  @Override
  public Boolean isEmpty() {
    return this.listHead == null;
  }

  @Override
  public Integer size() {
    int counter = 0;
    Node currentNode = this.listHead;
    while (currentNode != null) {
      counter++;
      currentNode = currentNode.getPointerToNextElem();
    }
    return counter;
  }

  @Override
  public Boolean contains(String element) {
    if (!isEmpty()) {
      Node currentNode = this.listHead;
      while (currentNode != null) {
        if (currentNode.getElement().equals(element)) {
          return true;
        }
        currentNode = currentNode.getPointerToNextElem();
      }
    }
    return false;
  }

  @Override
  public Boolean containsAll(String[] elements) {
    for (String element : elements) {
      if (!this.contains(element)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public ListOfStrings filterLargerThan(Integer largerThanBound) {
    StrLinkedList filteredList = new StrLinkedList();
    Node currentNode = this.listHead;
    while (currentNode != null) {
      if (currentNode.getElement().length() > largerThanBound) {
        if (filteredList.listHead == null) {
          filteredList.listHead = new Node(currentNode.getElement(), null);
        }
        else {
          filteredList.listHead = new Node(currentNode.getElement(), filteredList.listHead);
        }
      }
      currentNode = currentNode.getPointerToNextElem();
    }
    return filteredList;
  }

  @Override
  public Boolean hasDuplicates() {
    Node ptri = this.listHead;
    while (ptri != null) {
      Node ptrj = ptri.getPointerToNextElem();
      while (ptrj != null) {
        if (Objects.equals(ptri.getElement(), ptrj.getElement())) {
          return true;
        }
        ptrj = ptrj.getPointerToNextElem();
      }
      ptri = ptri.getPointerToNextElem();
    }
    return false;
  }

  @Override
  public ListOfStrings removeDuplicates() {
    StrLinkedList newList = new StrLinkedList();
    Node currentNode = this.listHead;
    while (currentNode != null) {
      boolean exist = false;
      Node ptr = newList.listHead;
      while (ptr != null) {
        if (Objects.equals(currentNode.getElement(), ptr.getElement())) {
          exist = true;
          break;
        }
        ptr = ptr.getPointerToNextElem();
      }
      if (!exist) {
        if (newList.listHead == null) {
          newList.listHead = new Node(currentNode.getElement(), null);
        }
        else {
          newList.listHead = new Node(currentNode.getElement(), newList.listHead);
        }
      }
      currentNode = currentNode.getPointerToNextElem();
    }
    return newList;
  }
}
