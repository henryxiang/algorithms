package algo.collection.list;

/**
 * Node
 */
public class Node<T> {
  protected T value;
  protected Node<T> next;

  public Node(T value) {
    this.value = value;
  }
}