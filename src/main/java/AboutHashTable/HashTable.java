package AboutHashTable;

public class HashTable <K,V> {

    private int DEFAULT_CAPACITY = 8;
    /**
     * 索引的数量
     */
    private int use;

    private float LOAD_FACTORY = 0.75f;

    /**
     * 实际元素的数量
     */
    private int size;

    private Entry<K,V>[] table;

    static class Entry <K,V> {
        K key;
        V value;
        Entry<K,V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : ((h = key.hashCode()) ^ (h >>> 16)) % table.length;
    }


    public boolean remove(K key) {
        Entry<K,V> e = table[hash(key)];
        if (e == null || e.next == null) return false;
        Entry<K,V> prev;
        Entry<K,V> headNote = table[hash(key)];
        while (e.next != null) {
            prev = e;
            e = e.next;
            if (e.key == key) {
                prev.next = e.next;
                size--;
                // 删除use的情况
                if (headNote.next == null) use--;
                return true;
            }
        }
        return false;
    }



//    public void put(K key, V value) {
//        int index = hash(key);
//        // 生成哨兵
//        if (table[index] == null) {
//            table[index] = new Entry<>(null, null, null);
//        }
//        // 考虑冲突
//        if (table[index].next == null) {
//            table[index].next = new Entry<>(key, value, null);
//            use++;
//            size++;
//            // 扩容只考虑use
//            if (use >= table.length * LOAD_FACTORY) {
//                resize();
//            }
//        } else {// 如果是覆盖值
//            Entry<K,V> temp = table[index];
//            do {
//                temp = temp.next;
//                if (temp.key == key) {
//                    temp.value = value;
//                    return;
//                }
//            } while (temp.next != null);
//            table[index].next = new Entry<>(key, value, table[index].next);
//            size++;
//        }
//    }


    public V get(K key) {
        Entry<K,V> e = table[hash(key)];
        if (e == null || e.next == null) return null;

        while (e.next != null) {
            e = e.next;
            if (e.key == key) {
                return e.value;
            }
        }
        return null;
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new Entry<>(null, null, null);
        }
        if (table[index].next == null) {
            table[index].next = new Entry<>(key, value, null);
            use++;
            size++;
            if (use >= table.length * LOAD_FACTORY) {
                resize();
            }
        } else {
            // 遍历查询覆盖
            Entry<K,V> e = table[index];
            do {
                e = e.next;
                if (e.key == key) {
                    e.value = value;
                    return;
                }
            } while (e.next != null);
            table[index].next = new Entry<>(key, value, table[index].next);
            size++;
        }
    }



    public HashTable() {
        table = (Entry<K, V>[]) new Entry[DEFAULT_CAPACITY];
    }


    private void resize() {
        Entry<K,V>[] oldTable = table;
        table = (Entry<K,V>[]) new Entry[table.length * 2];

        use = 0;

        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] == null || oldTable[i].next == null) continue;
            Entry<K,V> temp = oldTable[i];
            while (temp.next != null) {
                temp = temp.next;
                int index = hash(temp.key);
                if (table[index] == null) {
                    table[index] = new Entry<>(null, null, null);
                    use++;
                }

                table[index].next = new Entry<>(temp.key, temp.value, table[index].next);
            }
        }
    }



}
