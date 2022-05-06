package problem2;

import java.util.Objects;

public class ElementSetNode extends AbstractSet {

  private Integer element;
  private Set pointerToRest;

  public ElementSetNode(Integer element, Set pointerToRest) {
    this.element = element;
    this.pointerToRest = pointerToRest;
  }

  public ElementSetNode(Integer element) {
    this.element = element;
    this.pointerToRest = Set.emptySet();
  }

  public Integer getElement() {
    return element;
  }

  public Set getPointerToRest() {
    return pointerToRest;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ElementSetNode that = (ElementSetNode) o;
    return Objects.equals(element, that.element) && Objects.equals(pointerToRest,
        that.pointerToRest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(element, pointerToRest);
  }

  @Override
  public Boolean isEmpty() {
    return Boolean.FALSE;
  }

  @Override
  public Set add(Integer element) {
    if (this.contains(element)) {
      return this;
    } else {
      return super.add(element);
    }
  }

  @Override
  public Boolean contains(Integer element) {
    if (this.element.equals(element)) {
      return Boolean.TRUE;
    } else {
      return this.pointerToRest.contains(element);
    }
  }

  @Override
  public Set remove(Integer element) {
    if (!this.contains(element)) {
      return this;
    } else if (this.element.equals(element)) {
      return this.pointerToRest;
    } else {
      return new ElementSetNode(this.element, this.pointerToRest.remove(element));
    }
  }

  @Override
  public Integer size() {
    return 1 + this.pointerToRest.size();
  }
}
