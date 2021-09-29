package _3._19.task2;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Util {
    public static Set<String> getSortedSet(String... args) {
        Set<String> names = new TreeSet<>(Comparator.nullsFirst(Comparator.comparing(String::length)));
        Collections.addAll(names, args);
        return names;
    }
}
