package lesson19.task3;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        usingJava7(strings, numbers);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
        usingJava8(strings, numbers);
    }

    private static void usingJava8(List<String> strings, List<Integer> numbers) {
        System.out.println("Using Java 8");
        System.out.println("getCountEmptyString " + Util8.getCountEmptyStringUsingJava8(strings));
        System.out.println("getCountLength3 " + Util8.getCountLength3UsingJava8(strings));
        System.out.println("deleteEmptyStrings " + Util8.deleteEmptyStringsUsingJava8(strings));
        System.out.println("getMergedString " + Util8.getMergedStringUsingJava8(strings, "|"));
        System.out.println("getSquares " + Util8.getSquares(numbers));
        System.out.println("getMax " + Util8.getMax(numbers));
        System.out.println("getMin " + Util8.getMin(numbers));
        System.out.println("getSum " + Util8.getSum(numbers));
        System.out.println("getAverage " + Util8.getAverage(numbers));
        System.out.println("printRandomNumbers ");
        Util8.printRandomNumbers(5);
    }

    private static void usingJava7(List<String> strings, List<Integer> numbers) {
        System.out.println("Using Java 7");
        System.out.println("getCountEmptyString " + Util7.getCountEmptyStringUsingJava7(strings));
        System.out.println("getCountLength3 " + Util7.getCountLength3UsingJava7(strings));
        System.out.println("deleteEmptyStrings " + Util7.deleteEmptyStringsUsingJava7(strings));
        System.out.println("getMergedString " + Util7.getMergedStringUsingJava7(strings, "|"));
        System.out.println("getSquares " + Util7.getSquares(numbers));
        System.out.println("getMax " + Util7.getMax(numbers));
        System.out.println("getMin " + Util7.getMin(numbers));
        System.out.println("getSum " + Util7.getSum(numbers));
        System.out.println("getAverage " + Util7.getAverage(numbers));
        System.out.println("printRandomNumbers ");
        Util7.printRandomNumbers(5);
    }
}
