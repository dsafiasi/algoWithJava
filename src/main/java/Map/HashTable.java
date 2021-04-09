package Map;

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
        int index = hash(key);
        Entry<K,V> e = table[index];
        if (e == null || e.next == null) return false;
        Entry<K,V> prev;
        Entry<K,V> headEntry = table[index];
        while (e.next != null) {
            prev = e;
            e = e.next;
            if (e.key == key) {
                prev.next = e.next;
                if (headEntry.next == null) {
                    use--;
                }
                size--;
                return true;
            }
        }
        return false;
    }



    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new Entry<>(null, null, null);
        }
        if (table[index].next == null) {
            table[index].next = new Entry<>(key, value, table[index].next);
            use++;// use取决于solider.next 是否等于null
            size++;
            if (use >= table.length * LOAD_FACTORY) {
                resize();
            }
        } else {
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



    private void resize() {
        Entry<K,V>[] oldTable = table;
        table = (Entry<K, V>[]) new Entry[table.length * 2];
        use = 0;

        for (int i = 0; i < table.length; i++) {
            if (oldTable[i] == null || oldTable[i].next == null) continue;
            Entry<K,V> e = oldTable[i];
            while (e.next != null) {
                e = e.next;
                int index = hash(e.key);
                if (table[index] == null) {
                    table[index] = new Entry<>(null, null, null);
                    use++;
                }
                table[index].next = new Entry<>(e.key, e.value, table[index].next);
            }
        }

    }




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



    public HashTable() {
        table = (Entry<K, V>[]) new Entry[DEFAULT_CAPACITY];
    }


//    private void resize() {
//        Entry<K,V>[] oldTable = table;
//        table = (Entry<K,V>[]) new Entry[table.length * 2];
//
//        use = 0;
//
//        for (int i = 0; i < oldTable.length; i++) {
//            if (oldTable[i] == null || oldTable[i].next == null) continue;
//            Entry<K,V> temp = oldTable[i];
//            while (temp.next != null) {
//                temp = temp.next;
//                int index = hash(temp.key);
//                if (table[index] == null) {
//                    table[index] = new Entry<>(null, null, null);
//                    use++;
//                }
//
//                table[index].next = new Entry<>(temp.key, temp.value, table[index].next);
//            }
//        }
//    }



}
