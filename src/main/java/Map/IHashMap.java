package Map;

import java.util.HashMap;

public class IHashMap<K,V> {
  private Entry<K,V> table[];
  private final static int DEFAULT_CAPACITY = 16;
  private final static float LOAD_FACTOR = 0.75F;
  private int threshold;
  private int size;
  private int capacity;

  public IHashMap() {
    this.table = (Entry<K,V>[]) new Entry[DEFAULT_CAPACITY];
    this.capacity = DEFAULT_CAPACITY;
    this.threshold = (int) (DEFAULT_CAPACITY * LOAD_FACTOR);
  }

  public int size() {
    return size;
  }
  // 2倍扩容
  private void resize() {
    Entry<K,V>[] oldTab = table; int newCap;
    Entry<K,V>[] newTab = new Entry[newCap=(oldTab.length << 1)];
    for (int i = 0; i < oldTab.length; i++) {
      Entry entry = oldTab[i];

      while (entry != null) {
        newTab[hash(entry.key) & (newCap-1)] = entry;
        entry = entry.next;
      }
    }

    capacity = newCap;
    threshold = (int) (capacity * LOAD_FACTOR);
    table = newTab;
  }

  public V get(K k) {
    Entry entry = table[(capacity-1) & hash(k)];
    while (entry != null) {
      if (entry.key.equals(k)) return (V) entry.value;
      entry = entry.next;
    }
    return null;
  }


  public void put(K k, V v) {
    Entry<K,V> entry ;int i;
    if ((entry = table[i = (capacity-1) & hash(k)]) == null) {
      table[i] = new Entry<>(k, v, null);
      if (++size > threshold) resize();
      return;
    }
    if (entry.key.equals(k)) {
      entry.value = v;
      return;
    } else {
      while (entry.next != null) {
        entry = entry.next;
        if (entry.key.equals(k)) {
          entry.value = v;
          return;
        }
      }
      entry.next = new Entry<>(k, v, null);
      if (++size > threshold) resize();
    }
  }

  // from HashMap
  static final int hash(Object key) {
    int h;
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
  }


  static class Entry<K,V> {
    K key;
    V value;
    Entry<K,V> next;

    public Entry(K key, V value, Entry<K, V> next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }

  }

  public static void main(String[] args) {
    IHashMap<Integer, String> hashMap = new IHashMap<>();

//    hashMap.resize();

    for (int i = 0; i < 13; i++) {
      hashMap.put(i, i+"::");
    }
    System.out.println(hashMap.get(12));
    System.out.println(hashMap.get(0));
    System.out.println(hashMap.size());
    System.out.println(hashMap.threshold);
    System.out.println(hashMap.capacity);



//    System.out.println(hashMap.size());
//    System.out.println(hashMap.get(1));
//    System.out.println(hashMap.get(2));
//    System.out.println(hashMap.get(3));



  }

}
