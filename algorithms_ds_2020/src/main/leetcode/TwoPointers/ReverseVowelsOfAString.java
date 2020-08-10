package main.leetcode.TwoPointers;

import java.util.Arrays;
import java.util.HashSet;

class ReverseVowelsOfAString {

    private final static HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        if (s == null) return null;
        int i = 0;
        int j = s.length() - 1;
        char[] res = new char[s.length()];
        while (i <= j) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if (!vowels.contains(c1)) {
                res[i++] = c1;
            } else if (!vowels.contains(c2)) {
                res[j--] = c2;
            } else {
                res[i++] = c2;
                res[j--] = c1;
            }
        }

        return new String(res);
    }
}
