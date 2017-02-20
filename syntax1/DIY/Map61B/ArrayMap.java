//package Map61B;

import org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import org.junit.Test;


import static org.junit.Assert.*;

/**
 * An array based implementation of the Map61B class.
 */
public class ArrayMap<K, V> implements Map61B<K, V> {

    private K[] keys;
    private V[] vals;
    int size;

    public ArrayMap() {
        keys = (K[]) new Object[100];
        vals = (V[]) new Object[100];
    }

    /** Returns the index of the given key if it exists,
     *  -1 otherwise. */
    private int keyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }


    public boolean containsKey(K key) {
        return keyIndex(key) > -1;
    }

    public void put(K key, V value) {
        int index = keyIndex(key);
        if (index > -1) {
            vals[index] = value;
        } else {
            keys[size] = key;
            vals[size] = value;
            size++;
        }
    }

    public V get(K key) {
        int index = keyIndex(key);
        if (index == -1) {
            throw new IndexOutOfBoundsException();
        }
        return vals[keyIndex(key)];
    }

    public int size() {
        return size;
    }

    public List<K> keys() {
        List<K> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(keys[i]);
        }
        return list;
    }

    @Test
    public void test() {
        ArrayMap<Integer, Integer> am = new ArrayMap<Integer, Integer>();
        am.put(2, 5);
        int expected = 5;
        assertEquals((Integer) expected, am.get(2));
        assertEquals(expected, (long) am.get(2));
    }

    public static void main(String[] args) {
        ArrayMap<String, Integer> m = new ArrayMap<String, Integer>();
        m.put("horse", 3);
        m.put("fish", 9);
        m.put("house", 10);

        jh61b.junit.TestRunner.runTests("all", ArrayMap.class);
    }
}
