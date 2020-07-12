package Queue.exercise;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        topKFrequentElements.topKFrequent(nums, 2);
    }

    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num: nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (int key: map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }

        int[] res = new int[pq.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = pq.remove();
        }
        return res;
    }
}
