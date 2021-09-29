package _3._19.task3;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String args[]) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        //usingJava7(strings, numbers);
        usingJava8(strings, numbers);
    }

    private static void usingJava7(List<String> strings, List<Integer> numbers) {
        System.out.println("Using Java 7: ");
        System.out.println("List: " + strings);

        // Count empty strings
        long count = Util7.getCountEmptyStringUsingJava7(strings);
        System.out.println("Empty Strings: " + count);

        // Count length = 3 strings
        count = Util7.getCountLength3UsingJava7(strings);
        System.out.println("Strings of length 3: " + count);

        // Eliminate empty string
        List<String> filtered = Util7.deleteEmptyStringsUsingJava7(strings);
        System.out.println("Filtered List: " + filtered);

        // Eliminate empty string and join using comma.
        String mergedString = Util7.getMergedStringUsingJava7(strings, ", ");
        System.out.println("Merged String: " + mergedString);

        System.out.println("List: " + numbers);

        //get list of square of distinct numbers
        List<Integer> squaresList = Util7.getSquares(numbers);
        System.out.println("Squares List: " + squaresList);

        System.out.println("Highest number in List : " + Util7.getMax(numbers));
        System.out.println("Lowest number in List : " + Util7.getMin(numbers));
        System.out.println("Sum of all numbers : " + Util7.getSum(numbers));
        System.out.println("Average of all numbers : " + Util7.getAverage(numbers));
        System.out.println("Random Numbers: ");

        //print ten random numbers
        Util7.printRandomNumbers(10);
    }

    private static void usingJava8(List<String> strings, List<Integer> numbers) {
        System.out.println("Using Java 8: ");
        System.out.println("List: " + strings);

        long count = Util8.getCountEmptyStringUsingJava8(strings);
        System.out.println("Empty Strings: " + count);

        count = Util8.getCountLength3UsingJava8(strings);
        System.out.println("Strings of length 3: " + count);

        List<String> filtered = Util8.deleteEmptyStringsUsingJava8(strings);
        System.out.println("Filtered List: " + filtered);

        String mergedString = Util8.getMergedStringUsingJava8(strings, ", ");
        System.out.println("Merged String: " + mergedString);

        System.out.println("List: " + numbers);

        List<Integer> squaresList = Util8.getSquares(numbers);
        System.out.println("Squares List: " + squaresList);

        System.out.println("Highest number in List : " + Util8.getMax(numbers));
        System.out.println("Lowest number in List : " + Util8.getMin(numbers));
        System.out.println("Sum of all numbers : " + Util8.getSum(numbers));
        System.out.println("Average of all numbers : " + Util8.getAverage(numbers));
        System.out.println("Random Numbers: ");

        Util8.printRandomNumbers(10);
    }
}
