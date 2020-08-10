package main.leetcode.TwoPointers;

public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        if (c < 0) return false;
        int max = (int) Math.sqrt(c);
        int i = 0;
        int j = max;
        while(i <= j) {
            int tmp = i * i + j * j;
            if (tmp == c) {
                return true;
            } else if (tmp > c) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
