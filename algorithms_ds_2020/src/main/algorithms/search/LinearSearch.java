package main.algorithms.search;

import main.utils.ArrayGenerator;

public class LinearSearch {

    private LinearSearch() {}

    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] dataSizes = { 1000000, 10000000 };
        for (int n: dataSizes) {
            Integer[] data = ArrayGenerator.generateSortedArray(n);

            long startTime = System.nanoTime();
            for (int i = 0; i < 100; i++) {
                LinearSearch.search(data, n);
            }
            long endTime = System.nanoTime();

            double totalTime = (endTime - startTime) / 1000000000.0;

            System.out.println("Size: " + n + ", 100 runs, " + "time: " + totalTime);
        }
    }
}
