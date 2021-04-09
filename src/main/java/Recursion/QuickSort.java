package Recursion;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] a, int n) {quickSortI(a,0,n-1);}



    private static void quickSortI(int[] a, int p, int q) {
        if (p >= q) return;

        int pivotIndex = partition(a,p,q);

        quickSortI(a, p, pivotIndex-1);
        quickSortI(a, pivotIndex+1, q);
    }


    private static int partition(int[] a, int p, int q) {
        int i = p,j = p;
        int pivot = a[q];
        while (j < q) {
            if (a[j] < pivot) {
                if (i == j) {
                    i++;
                } else {
                    int temp = a[j];
                    a[j] = a[i];
                    a[i++] = temp;
                }
            }
            j++;
        }

        a[j] = a[i];
        a[i] = pivot;
        return i;
    }


    public static void main(String[] args) {
        //[-22, -1, 0, 1, 2, 4, 4, 5, 7, 666]
        int[] toSorts = {4,2,1,5,666,0,-1,7,-22,4};
        QuickSort.quickSort(toSorts, toSorts.length);
        System.out.println(Arrays.toString(toSorts));

    }

}
