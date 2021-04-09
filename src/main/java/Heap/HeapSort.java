package Heap;


public class HeapSort {
    public static void sort(int[] arr) {
        if (arr.length <= 1) return;
        // 1. 建堆
        buildHeap(arr);
        // 2. 排序
        int n = arr.length-1;
        while (n > 0) {
            swap(arr, 0, n);
            heapify(arr, --n, 0);
        }
    }

    /**
     * 自上而下堆化
     *
     * @param arr
     * @param n 最后堆元素的下标
     * @param i 要堆化的元素的下标
     */
    private static void heapify(int[] arr, int n, int i) {
        while (true) {
            int maxPos = i;

            if (i * 2 + 1 <= n && arr[i] < arr[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (i * 2 + 2 <= n && arr[maxPos] < arr[i * 2 + 2]) {
                maxPos = i * 2 + 2;
            }
            if (maxPos == i) break;
            swap(arr, i, maxPos);

            i = maxPos;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void buildHeap(int[] arr) {
        for (int i = (arr.length-1)/2; i >= 0; i--) {
            heapify(arr, arr.length-1, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {-11,0,6,2,4,1,7,8,9,11,241,41431,5353};
        HeapSort.sort(arr);
        for (int i : arr) {
            System.out.print(i + "、");
        }
    }

}
