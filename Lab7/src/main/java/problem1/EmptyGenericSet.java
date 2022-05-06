package problem1;

public class EmptyGenericSet<E> implements Set<E> {

  public EmptyGenericSet() {
  }

  @Override
  public Boolean isEmpty() {
    return Boolean.TRUE;
  }

  @Override
  public Set<E> add(E element) {
    return new NonEmptyGenericSet<E>(element);
  }

  @Override
  public Boolean contains(Object element) {
    return Boolean.FALSE;
  }

  @Override
  public Set<E> remove(Object element) {
    return this;
  }

  @Override
  public Integer size() {
    return 0;
  }
}
