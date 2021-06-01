package Heap;

import java.util.Arrays;

public class HeapSort {
  public static void heapSort(int[] a) {
    // 建堆
    buildHeap(a);

    // 排序
    sort(a);
  }


  private static void sort(int[] a) {
    for (int i = a.length-1; i >= 0; i--) {
      swap(a, 0, i);
      heapify(a, 0, i-1);
    }
  }


  /**
   * 建堆: 将每个非叶子节点进行自下而上堆化
   * 数组从下标0开始，因此, a.length-1-1 / 2 为最后一个叶子节点的父节点
   * @param a
   */
  private static void buildHeap(int[] a) {
    for (int i = (a.length-2)/2; i >= 0; i--) {
      heapify(a, i, a.length-1);
    }
  }

  /**
   * 自上而下堆化
   */
  private static void heapify(int[] a, int index, int n) {
    while (true) {
      int maxPos = index;
      if (2*index+1 <= n && a[index] < a[2*index+1]) {
        maxPos = 2*index+1;
      }

      if (2*index+2 <= n && a[maxPos] < a[2*index+2]) {
        maxPos = 2*index+2;
      }

      if (maxPos == index) break;
      swap(a, index, maxPos);
      index = maxPos;
    }
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static void main(String[] args) {
    int[] a = {3,4,1,6,10,7,9,2,1};
    heapSort(a);
    System.out.println(Arrays.toString(a));
  }


}
