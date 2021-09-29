package _3._19.task1;

import java.util.Map;

public class Main {
    /**
    * Напишите метод, который получает на вход массив элементов типа К (Generic) и возвращает Map<K, Integer>,
    * где K — значение из массива, а Integer — количество вхождений в массив.
     */
    public static void main(String[] args) {
        Integer[] numbers = {1, 1, 1, 2, 3, 0, 0, 5, 6, 7, 8, 8};
        Map<Integer, Integer> map = Util.countValues(numbers);
        map.forEach((key, value) -> {
            System.out.printf("Key: %d, Value: %d%n", key, value);
        });
    }
}
