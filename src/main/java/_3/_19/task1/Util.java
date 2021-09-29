package _3._19.task1;

import java.util.HashMap;
import java.util.Map;

public class Util {
    public static <K> Map<K, Integer> countValues(K[] ks) {
        Map<K, Integer> map = new HashMap<>();
        for (K k : ks) {
            map.compute(k, (k1, count) -> count == null ? 1 : count + 1);
        }
        return map;
    }
}
