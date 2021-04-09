package Sorts;

import java.util.Arrays;

public class QuickSort {

    public void quickSort(int[] a, int n) {
        if (n <= 1) return;

        quickSort(a, 0, n-1);
    }

    private void quickSort(int[] a, int p, int r) {
        if (p >= r) return;

        int pivot = partition(a, p, r);
        quickSort(a, p, pivot-1);
        quickSort(a, pivot+1, r);
    }


    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private int partition(int[] a, int p, int q) {
        int i = p,j = p;
        int pivot = q;

//        int pivot = partition(a, p, q);
        for (; j < pivot; j++) {
            if (a[j] < a[pivot]) {
                if (i == j) {
                    i++;
                } else {
                    swap(a, i, j);
                    i++;
                }
            }
        }
        swap(a, i, pivot);
        return i;
    }

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int[] a = {4,2,1,5,666,0,-1,7,-22,4};

//        int[] a = {1,5,7,83,1,5,23,44};
        q.quickSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }


}
