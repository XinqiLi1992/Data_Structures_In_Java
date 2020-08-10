package main.leetcode.TwoPointers;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while(i < j) {
            int tmp = numbers[i] + numbers[j];
            if (tmp == target) {
                break;
            } else if (tmp < target){
                i++;
            } else {
                j--;
            }
        }

        return new int[]{i + 1, j + 1};
    }
}
