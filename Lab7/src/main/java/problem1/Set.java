package problem1;

public interface Set<E> {

  static Set emptySet() {
    return new EmptyGenericSet();
  }

  Boolean isEmpty();

  Set<E> add(E element);

  Boolean contains(E element);

  Set<E> remove(E element);

  Integer size();
}
