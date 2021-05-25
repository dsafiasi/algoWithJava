package Sorts;

public class BubbleSort {
    public static void bubbleSort(int[] a, int n) {
        bubbleSort(a, 0, n-1);
    }
    private static void bubbleSort(int[] a, int p, int r) {
        for (int i = r; i > p; i--) {
            boolean flag = false;
            int k = p;
            while (k < i) {
                if (a[k] > a[k+1]) {
                    int temp = a[k];
                    a[k] = a[k+1];
                    a[k+1] = temp;
                    flag = true;
                }
                k++;
            }
            if (! flag) break;
        }
    }
}
