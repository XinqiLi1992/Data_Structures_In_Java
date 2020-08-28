package main.algorithms.search;

public class BinarySearch {
    private BinarySearch() {}

    public static <E extends Comparable<E>> int search(E[] data, E target) {
        int l = 0;
        int r = data.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) == 0) {
                return mid;
            }

            if (data[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static <E extends Comparable<E>> int searchR(E[] data, E target) {
        return searchR(data, 0, data.length - 1, target);
    }

    public static <E extends Comparable<E>> int searchR(E[] data, int l, int r, E target) {
        if (l > r) return -1;
        int mid = l + (r - l) / 2;
        if (data[mid].compareTo(target) == 0) {
            return mid;
        }
        if (data[mid].compareTo(target) < 0) {
            return searchR(data, mid + 1, r, target);
        }

        return searchR(data, l, mid - 1, target);
    }

    // upper: > target 的最小值的索引
    public static <E extends Comparable<E>> int upper(E[] data, E target) {
        int l = 0;
        int r = data.length;

        // data[l, r] 寻找解
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) <= 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }

    // < target 的最大值
    public static <E extends Comparable<E>> int lower(E[] data, E target) {
        int l = -1;
        int r = data.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (data[mid].compareTo(target) < 0) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static <E extends  Comparable<E>> int lowerCeil(E[] data, E target) {
        int l = 0;
        int r = data.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }

    // 不存在 返回 > target, 返回最小值索引
    // 存在 返回 = target 最大索引
    public static <E extends  Comparable<E>> int upperCeil(E[] data, E target) {
        int u = upper(data, target);
        if (u - 1 >= 0 && data[u - 1].compareTo(target) == 0) {
            return u - 1;
        }
        return u;
    }

    // 不存在 返回 < target 最大值
    // 存在 返回 = target 最小值
    public static <E extends Comparable<E>> int lowerFloor(E[] data, E target) {
        int l = lower(data, target);
        if (l + 1 < data.length && data[l + 1].compareTo(target) == 0) {
            return l + 1;
        }
        return l;
    }

    // 不存在 返回 < target 最大值
    // 存在 返回 = target 最大值
    public static <E extends Comparable<E>> int upperFloor(E[] data, E target) {
        int l = -1;
        int r = data.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (data[mid].compareTo(target) <= 0) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 1, 3, 3, 5, 5};
        for (int i = 0; i <= 6; i++) {
            System.out.print(BinarySearch.upper(arr, i) + " ");
        }
        System.out.println();
        for (int i = 0; i <= 6; i++) {
            System.out.print(BinarySearch.upperCeil(arr, i) + " ");
        }
        System.out.println();

        for (int i = 0; i <= 6; i++) {
            System.out.print(BinarySearch.lowerCeil(arr, i) + " ");
        }
        System.out.println();

        for (int i = 0; i <= 6; i++) {
            System.out.print(BinarySearch.lower(arr, i) + " ");
        }
        System.out.println();

        for (int i = 0; i <= 6; i++) {
            System.out.print(BinarySearch.lowerFloor(arr, i) + " ");
        }
        System.out.println();

        for (int i = 0; i <= 6; i++) {
            System.out.print(BinarySearch.upperFloor(arr, i) + " ");
        }
        System.out.println();

    }
}
