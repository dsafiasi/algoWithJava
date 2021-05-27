package List;

public class ILinkedList<E> {
  private int count = 0;
  private Node head = null;
  private Node tail = null;

  public void addFirst(E e) {
    Node node = head;
    Node newNode = new Node(null, node, e);
    head = newNode;
    if (head == null) {
      tail = newNode;
    } else {
      node.prev = newNode;
    }
    count++;
  }

  private void unlink(Node<E> node) {
    Node prev = node.prev;
    Node next = node.next;

    if (prev == null) {
      head = next;
    } else {
      prev.next = next;
      node.prev = null;
    }

    if (next == null) {
      tail = prev;
    } else {
      next.prev = prev;
      node.next = null;
    }
    node.element = null;
    count--;
  }

  public void remove(int index) {
    checkIndex(index);
    unlink(node(index));
  }
  public void addLast(E e) {
    final Node node = tail;
    final Node newNode = new Node(node, null, e);
    tail = newNode;
    if (node == null) {
      head = newNode;
    } else {
      node.next = newNode;
    }
    count++;
  }


  private Node node(int index) {
    if (index < (count >> 1)) {
      Node node = head;
      for (int i = 0; i < index; i++) {
        node = node.next;
      }
      return node;
    } else {
      Node node = tail;
      for (int i = count-1; i > index; i--) {
        node = node.next;
      }
      return node;
    }
  }


  private void linkBefore(E e, Node<E> node) {
    // assert node != null;
    final Node pred = node.prev;
    final Node newNode = new Node(pred, node, e);
    node.prev = newNode;
    if (pred == null) {
      head = newNode;
    } else {
      pred.next = newNode;
    }
    count++;
  }

  public int indexOf(E e) {
    Node node = head;
    for (int i = 0; i < count; i++) {
      if (node.element.equals(e)) return i;
      node = node.next;
    }
    return -1;
  }

  public boolean contains(E e) {
    return indexOf(e) >= 0;
  }

  public void add(int index, E e) {
    checkIndexForAdd(index);
    if (index == count) addLast(e);
    else linkBefore(e, node(index));
  }

  public E get(int index) {
    checkIndex(index);
    Node node = node(index);
    return (E) node.element;
  }

  public void add(E e) {
    addLast(e);
  }

  public int size() {
    return count;
  }

  private void checkIndex(int index) {
    if (index < 0 || index >= count) {
      throw new IllegalArgumentException();
    }
  }
  private void checkIndexForAdd(int index) {
    if (index < 0 || index > count) {
      throw new IllegalArgumentException();
    }
  }

  public String printAll() {
    Node node = this.head;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < count; i++) {
      sb.append(node.element+"-->");
      node = node.next;
    }
    sb.append("null");
    return sb.toString();
  }


  class Node<E> {
    Node prev;
    Node next;
    E element;

    public Node(Node prev, Node next, E element) {
      this.prev = prev;
      this.next = next;
      this.element = element;
    }
  }

  public static void main(String[] args) {
    ILinkedList<String> linkedList = new ILinkedList<>();
    linkedList.add("a");
    linkedList.add("b");
    linkedList.add("c");
    linkedList.add("d");
    linkedList.add(0, "A");
    linkedList.add(1, "B");
    System.out.println(linkedList.indexOf("Q"));

//    linkedList.add("d");

//    linkedList.add(0, "A");
    System.out.println(linkedList.printAll());

//    linkedList.remove(0);
//    System.out.println(linkedList.get(0).getElement());
//    System.out.println(linkedList.size());
//    System.out.println(linkedList.get(7).getElement());

  }

}
