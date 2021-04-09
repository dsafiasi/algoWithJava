package Map;

import java.util.Set;

public interface Map<K,V> {
    void put(K key, V value);
    V get();
    Set<Map.Entry<K, V>> entrySet();


    interface Entry<K,V> {
        K getKey();
        V getValue();
    }
}
