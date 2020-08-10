package main.leetcode.TwoPointers;

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }

        return true;
    }

    private boolean isPalindrome(String s, int l, int r) {
        for (int i = l, j = r; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
