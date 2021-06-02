package Sorts;

import java.util.Arrays;

public class CountingSort {

  /**
   *
   * @param a 待排序数组
   * @param p 数据的左范围
   * @param r 数据的右范围
   */
  public static void countingSort(int[] a, int p, int r) {
    if (a.length < 2) return ;

    int[] count = new int[r-p+1];
    for (int i = 0; i < a.length; i++) {
      count[a[i]]++;
    }
    // 从左至右 依次累加
    for (int i = 1; i < count.length; i++) {
      count[i] += count[i-1];
    }

    int[] temp = new int[a.length];// 用于存储已排好序的数组
    // 从后向前依次遍历待排序数组a
    for (int i = a.length-1; i >= 0; i--) {
      temp[--count[a[i]]] = a[i];
    }

    // 拷贝回原数组
    for (int i = 0; i < temp.length; i++) {
      a[i] = temp[i];
    }

  }

  public static void main(String[] args) {
    int[] a = {2,4,1,0,0,5,3,1};
    countingSort(a, 0, 5);
    System.out.println(Arrays.toString(a));
  }


}
