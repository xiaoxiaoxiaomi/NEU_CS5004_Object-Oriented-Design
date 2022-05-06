package problem1;

public class NonEmptyGenericSet<E> implements Set<E> {

  private E headElement;
  private Set<E> restOfSet;

  public NonEmptyGenericSet(E headElement) {
    this.headElement = headElement;
    this.restOfSet = new EmptyGenericSet<>();
  }

  public NonEmptyGenericSet(E headElement, Set<E> restOfSet) {
    this.headElement = headElement;
    this.restOfSet = restOfSet;
  }

  @Override
  public Boolean isEmpty() {
    return Boolean.FALSE;
  }

  @Override
  public Set<E> add(E element) {
    if (this.contains(element)) {
      return this;
    } else {
      return new NonEmptyGenericSet<E>(element, this);
    }
  }

  @Override
  public Boolean contains(E element) {
    if (this.headElement.equals(element)) {
      return Boolean.TRUE;
    } else {
      return this.restOfSet.contains(element);
    }
  }

  @Override
  public Set<E> remove(E element) {
    if (!this.contains(element)) {
      return this;
    } else if (this.headElement.equals(element)) {
      return this.restOfSet;
    } else {
      return new NonEmptyGenericSet<E>(this.headElement, this.restOfSet.remove(element));
    }
  }

  @Override
  public Integer size() {
    return 1 + this.restOfSet.size();
  }
}
