package Sorts;

public class InsertionSort {
    public static void insertSort(int[] a, int n) {
        insertSort(a, 0, n-1);
    }

    private static void insertSort(int[] a, int p, int r) {
        int j = p+1;
        while (j <= r) {
            int elem = a[j];
            int k = j-1;
            // 从后向前
            for (; k >= p; k--) {
                if (a[k] <= elem) {
                    break;
                }
            }
            // 插入点为k+1;
            // k+1 往后搬到j [k+2] = [k+1]
            // k =-1  [1] = [0]
            int m = j;
            while (m >= k+2) {
                a[m] = a[m-1];
                m--;
            }
            a[k+1] = elem;
            j++;
        }
    }
}
