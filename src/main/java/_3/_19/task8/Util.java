package _3._19.task8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {
    public static void bubbleSort(int[] nums) {
        List<Integer> positiveNums = new ArrayList<>(nums.length);
        List<Integer> negativeNums = new ArrayList<>(nums.length);

        for (int num : nums) {
            if (num >= 0) {
                positiveNums.add(num);
            } else {
                negativeNums.add(num);
            }
        }
        sort(positiveNums);
        sort(negativeNums);
        positiveNums.addAll(negativeNums);
        System.out.println(positiveNums);
    }

    private static void sort(List<Integer> nums) {
        for (int i = 0; i < nums.size() - 1; i++) {
            for (int j = 0; j < nums.size() - i - 1; j++) {
                if (nums.get(j) > nums.get(j + 1)) {
                    int temp = nums.get(j);
                    nums.set(j, nums.get(j + 1));
                    nums.set(j + 1, temp);
                }
            }
        }
    }
}
