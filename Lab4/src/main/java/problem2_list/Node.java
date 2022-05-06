package problem2_list;

import java.util.Objects;

public class Node {
  private String element;
  private Node pointerToNextElem;

  public Node(String element, Node pointerToNextElem) {
    this.element = element;
    this.pointerToNextElem = pointerToNextElem;
  }

  public String getElement() {
    return element;
  }

  public Node getPointerToNextElem() {
    return pointerToNextElem;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Node node = (Node) o;
    return Objects.equals(element, node.element) && Objects.equals(
        pointerToNextElem, node.pointerToNextElem);
  }

  @Override
  public int hashCode() {
    return Objects.hash(element, pointerToNextElem);
  }

  @Override
  public String toString() {
    return "Node{" +
        "element='" + element + '\'' +
        ", pointerToNextElem=" + pointerToNextElem +
        '}';
  }
}
