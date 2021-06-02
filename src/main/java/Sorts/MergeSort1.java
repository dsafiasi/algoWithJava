package Sorts;


import java.util.Arrays;

/**
 * 递推公式：mergeSort(p,r)=merge( mergeSort(p,q-1),mergeSort(q+1,r) ); q = (p+r)/2;
 * 终止条件：if(p>=r) return;
 */
public class MergeSort1 {
  public static void mergeSort(int[] a) {
    mergeSort(a, 0, a.length-1);
  }

  private static void mergeSort(int[] a, int p, int r) {
    if (p >= r) return;
    int q = (p+r)/2;
    // [p,q], [q+1,r]
    mergeSort(a, p, q);
    mergeSort(a, q+1, r);

    merge(a, p, q, r);
  }

  private static void merge(int[] a, int p, int q, int r) {
    int[] temp = new int[r-p+1];
    int i = p, j = q+1, k = 0;

    while (i <= q && j <= r) {
      if (a[i] <= a[j]) {
        temp[k++] = a[i++];
      } else {
        temp[k++] = a[j++];
      }
    }
    int start = i, end = q;
    if (j <= r) {
      start = j;
      end = r;
    }

    while (start <= end) {
      temp[k++] = a[start++];
    }

    // 搬迁回原数组
    for (int l = 0; l < temp.length; l++) {
      a[p+l] = temp[l];
    }
  }

  public static void main(String[] args) {
    int[] a = {222,34,11,33,221,4456,0};
    MergeSort1.mergeSort(a);

    System.out.println(Arrays.toString(a));
  }

}
