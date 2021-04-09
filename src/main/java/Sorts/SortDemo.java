package Sorts;

import java.util.Arrays;

public class SortDemo {

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




    public static void main(String[] args) {
        int[] toSorts = {4,2,1,5,666,0,-1,7,-22,4};
        SortDemo.bubbleSort(toSorts, 1, toSorts.length-1);
//        QuickSort2.quickSort(toSorts, toSorts.length);
        System.out.println(Arrays.toString(toSorts));
    }
}
