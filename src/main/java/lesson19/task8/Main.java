package lesson19.task8;

import java.util.Arrays;

public class Main {
    /**
     * Написать сортировку пузырьком
     * Если положительные то от меньшего к большему
     * Если числа отрицательные то от большего к меньшему
     * Выводмть сначала положительные, потом отрицательные
     */
    public static void main(String[] args) {
        int[] nums = {7, -5, 3, 2, 1, 0, 45, -18, -25};
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(nums));
        Util.bubbleSort(nums);
    }
}
