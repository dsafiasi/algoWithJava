package Sorts;


import java.util.Arrays;

/**
 * 递推公式：quickSort(p,r)=quickSort(p,q-1)+quickSort(q+1,r); q = partition(p,r);
 * 终止条件：if(p>=r) return;
 */
public class QuickSort {
  public static void quickSort(int[] a) {
    quickSort(a, 0, a.length-1);
  }
  public static void quickSort(int[] a, int p, int r) {
    if (p >= r) return;

    int q = partition(a, p, r);
    quickSort(a, p, q-1);
    quickSort(a, q+1, r);
  }


  private static int partition(int[] a, int p, int r) {
    int i = p, j = p, pivot = a[r];
    for (; j < r; j++) {
      if (a[j] < pivot) {
        if (i == j) i++;
        else {
          // swap
          int temp = a[i];
          a[i++] = a[j];
          a[j] = temp;
        }

      }
    }
    // 交换a[i] 与 a[r]
    int temp = a[i];
    a[i] = a[r];
    a[r] = temp;
    return i;
  }

  public static void main(String[] args) {
    int[] a = {4,2,1,5,666,0,-1,7,-22,4};
    QuickSort.quickSort(a);
    System.out.println(Arrays.toString(a));
  }

}
