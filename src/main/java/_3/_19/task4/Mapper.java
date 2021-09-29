package _3._19.task4;

import java.util.Map;

@FunctionalInterface
public interface Mapper<T> {
    void populateValuesTo(Map<String, String> values, T object);
}
