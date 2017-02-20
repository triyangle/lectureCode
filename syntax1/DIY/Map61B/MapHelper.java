//package Map61B;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;

/**
 * Class to demonstrate how generic methods work in Java.
 */
public class MapHelper {
    /* Write the following three methods:
    /* get(Key) : Return item in map if it exists. */
    public static <K, V> V get(Map61B<K, V> map, K key) {
        return map.containsKey(key) ? map.get(key) : null;
    }

    /* maxKey() : Returns max of all keys. Works only if x and y have comparable data. */
    public static <K extends Comparable<K>, V> K maxKey(Map61B<K, V> map) {
        List<K> keys = map.keys();
        K max = keys.get(0);
        for (int i = 1; i < keys.size(); i++) {
            K current = keys.get(i);
            if (current.compareTo(max) > 0) {
                max = current;
            }
        }
        return max;
    }

    /* allBark(): Makes all keys bark, but only works for Dogs. */

    @Test
    public void testGet() {
        Map61B<String, Integer> m = new ArrayMap<String, Integer>();
        m.put("horse", 3);
        m.put("fish", 9);
        m.put("house", 10);

        Integer actual = MapHelper.get(m, "fish");
        Integer expected = 9;
        assertEquals(expected, actual);

        assertEquals(null, MapHelper.get(m, "asdfasdf"));
    }

    @Test
    public void testMaxKey() {
        Map61B<String, Integer> m = new ArrayMap<String, Integer>();
        m.put("horse", 3);
        m.put("fish", 9);
        m.put("house", 10);

        String actual = MapHelper.maxKey(m);
        String expected = "house";
        assertEquals(expected, actual);
    }

    public static void main(String... args) {
        jh61b.junit.TestRunner.runTests("all", MapHelper.class);
    }
}
