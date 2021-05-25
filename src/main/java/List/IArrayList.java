package List;

public class IArrayList<T> {
  private static final int DEFAULT_CAPACITY = 10;
  private T[] data = null;
  private int size = 0;

  public IArrayList() {
    this.data = (T[]) new Object[DEFAULT_CAPACITY];
  }
  public IArrayList(int capacity) {
    this.data = (T[]) new Object[capacity];
  }

  private void resize(int capacity) {
    T[] newData = (T[]) new Object[capacity];
    for (int i = 0; i < size; i++) {
      newData[i] = data[i];
    }
    data = newData;
  }

  public int count() {
    return size;
  }
  public T get(int index) {
    checkIndex(index);
    return data[index];
  }

  public boolean contains(T element) {
    if (indexOf(element) != -1) return true;
    return false;
  }
  public int indexOf(T element) {
    for (int i = 0; i < size; i++) {
      if (data[i].equals(element)) return i;
    }
    return -1;
  }
  public void removeElement(T element) {
    int index = indexOf(element);
    if (index != -1) {
      remove(index);
    }
  }
  public T remove(int index) {
    checkIndex(index);
    T ret = data[index];
    for (int i = index+1; i < size; i++) {
      data[i-1] = data[i];
    }
    data[--size] = null;
    // 当超过 3/4 的空闲,且data.length != 1
    if (size == data.length/4 && data.length/2 != 0) {
      resize(data.length/2);
    }
    return ret;
  }

  public void update(int index, T newElement) {
    checkIndex(index);
    data[index] = newElement;
  }
  public void add(int index, T element) {
    checkIndexForAdd(index);
    // 先检查扩容
    if (size == data.length) resize(data.length * 2);
    for (int i = size-1; i >= index; i--) {
      // 向后搬迁，腾出位置
      data[i+1] = data[i];
    }
    data[index] = element;
    size++;
  }
  public void add(T element) {
    add(size, element);
  }

  public int getCapacity() {
    return data.length;
  }

  private void checkIndexForAdd(int index) {
    if (index < 0 || index > size)
      throw new IllegalArgumentException("Add failed! Require index >=0 and index < size.");
  }
  private void checkIndex(int index) {
    if (index < 0 || index >= size)
      throw new IllegalArgumentException("Require index >=0 and index <= size.");
  }

  public static void main(String[] args) {
    IArrayList<String> list = new IArrayList<>(4);
    list.add("a");
    list.add("b");
    list.add("c");
    list.add("d");
    list.add("e");
    System.out.println(list.contains("a"));
    list.removeElement("a");
    System.out.println(list.contains("a"));

    // test resize()
//    System.out.println(list.getCapacity());
    // test update()
    list.update(0, "A");
    System.out.println(list.get(0));

    // test remove()
    list.remove(0);
    System.out.println(list.get(0));
    list.remove(0);
    list.remove(0);
    list.remove(0);

    // 测试缩容
    System.out.println(list.count());// 1 == length/4
    System.out.println(list.getCapacity()); // 4/2


  }


}
