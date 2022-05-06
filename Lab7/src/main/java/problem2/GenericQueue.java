package problem2;

public class GenericQueue<Type> implements Queue<Type> {

  private ILinkedList<Type> front;

  public GenericQueue() {
    this.front = new EmptyNode<>();
  }

  @Override
  public Boolean isEmpty() {
    return this.size().equals(0);
  }

  @Override
  public void enqueue(Type n) {
    this.front = this.front.insertAt(n, this.size());
  }

  @Override
  public Type dequeue() throws EmptyQueueException {
    if (this.size().equals(0)) {
      throw new EmptyQueueException();
    }
    Type frontItem = this.front.getItem();
    this.front = this.front.getRest();
    return frontItem;
  }

  @Override
  public void remove(Type elem) {
    this.front = this.front.remove(elem);
  }

  @Override
  public Integer size() {
    return this.front.count();
  }
}
