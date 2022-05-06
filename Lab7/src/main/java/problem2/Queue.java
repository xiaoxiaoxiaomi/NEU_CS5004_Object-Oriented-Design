package problem2;

public interface Queue<Type> {

  static Queue create() {
    return new GenericQueue();
  }

  Boolean isEmpty();

  void enqueue(Type n);

  Type dequeue() throws EmptyQueueException;

  void remove(Type elem);

  Integer size();
}
