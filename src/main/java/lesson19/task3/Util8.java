package lesson19.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Util8 {
    public static long getCountEmptyStringUsingJava8(List<String> strings) {
        return strings.stream()
                .filter(String::isEmpty)
                .count();
    }

    public static long getCountLength3UsingJava8(List<String> strings) {
        return strings.stream()
                .filter(string -> string.length() == 3)
                .count();
    }

    public static List<String> deleteEmptyStringsUsingJava8(List<String> strings) {
        return strings.stream()
                .filter(string -> !string.isEmpty())
                .collect(Collectors.toList());
    }

    public static String getMergedStringUsingJava8(List<String> strings, String separator) {
        return strings.stream()
                .filter(string -> !string.isEmpty())
                .collect(Collectors.joining(separator));
    }

    public static List<Integer> getSquares(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .map(i -> i * i)
                .collect(Collectors.toList());
    }

    public static int getMax(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(x -> x)
                .summaryStatistics()
                .getMax();
    }

    public static int getMin(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(x -> x)
                .summaryStatistics()
                .getMin();
    }

    public static long getSum(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(x -> x)
                .summaryStatistics()
                .getSum();
    }

    public static double getAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(x -> x)
                .summaryStatistics()
                .getAverage();
    }

    public static void printRandomNumbers(int count) {
        Random random = new Random();
        random.ints()
                .limit(count)
                .sorted()
                .forEach(System.out::println);
    }
}
