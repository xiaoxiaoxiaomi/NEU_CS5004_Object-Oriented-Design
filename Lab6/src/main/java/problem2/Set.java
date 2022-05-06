package problem2;

public interface Set {

  static Set emptySet() {
    return new EmptySetNode();
  }

  Boolean isEmpty();

  Set add(Integer element);

  Boolean contains(Integer element);

  Set remove(Integer element);

  Integer size();
}
