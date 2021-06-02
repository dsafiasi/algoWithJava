package Sorts;

import java.util.Arrays;
import java.util.Random;

public class BucketSort {
  public static void bucketSort(int[] a, int bucketSize) {
    if (a.length < 2) return;

    int minValue = a[0], maxValue = a[1];
    for (int i = 0; i < a.length; i++) {
      if (a[i] < minValue) minValue = a[i];
      else if (a[i] > maxValue) maxValue = a[i];
    }

    int bucketCount = (maxValue - minValue) / bucketSize + 1;
    int[][] buckets = new int[bucketCount][bucketSize];
    int[] indexArr = new int[bucketCount];// 记录buckets[i]的元素数量，扩容用

    for (int i = 0; i < a.length; i++) {
      int bucketIndex = (a[i] - minValue) / bucketSize;
      if (indexArr[bucketIndex] == buckets[bucketIndex].length) {
        ensureCapacity(buckets, bucketIndex);
      }
      buckets[bucketIndex][indexArr[bucketIndex]++] = a[i];

      int j = 0;
      // 对每个桶单独进行排序 此处使用快速排序
      for (int k = 0; k < bucketCount; k++) {
        // 此处需要注意，排序范围是[0 , indexArr[k]-1],而非[0 , buckets[k].length]
        QuickSort.quickSort(buckets[k], 0, indexArr[k]-1);

        // 由于quickSort是原地排序，因此将已好序的数组直接复制回原数组
        for (int i1 = 0; i1 < indexArr[k]; i1++) {
          a[j++] = buckets[k][i1];
        }
      }
    }

  }

  private static void ensureCapacity(int[][] buckets, int bucketIndex) {
    int[] oldArr = buckets[bucketIndex];
    int[] newArr = new int[oldArr.length * 2];
    for (int i = 0; i < oldArr.length; i++) {
      newArr[i] = oldArr[i];
    }
    buckets[bucketIndex] = newArr;
  }

  public static void main(String[] args) {
    int[] arr = new int[50];
    Random random = new Random();
    for (int i = 0; i < 50; i++) {
      arr[i] = random.nextInt(51);
    }
    System.out.println("before:");
    System.out.println(Arrays.toString(arr));
    BucketSort.bucketSort(arr, 5);
    System.out.println("after:");
    System.out.println(Arrays.toString(arr));

  }


}
