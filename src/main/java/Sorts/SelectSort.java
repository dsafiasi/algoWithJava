package Sorts;

public class SelectSort {
    public static void selectSort(int[] a, int n) {
        selectSort(a, 0, n-1);
    }

    private static void selectSort(int[] a, int p, int r) {
        int i = p,j = 1;

        while (j < r) {
            int min = a[j], k = j;
            for (int l = j+1; l <= r; l++) {
                if (a[l] < min) {
                    min = a[l];
                    k = l;
                }
            }
            int temp = a[i];
            a[i++] = min;
            a[k] = temp;
            j++;
        }
    }
}
