package Set.exercise;

import java.util.ArrayList;
import java.util.TreeSet;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int num: nums1) {
            set.add(num);
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int num: nums2) {
            if (set.contains(num)) {
                list.add(num);
                set.remove(num);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
