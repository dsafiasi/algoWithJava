package Sorts;

import java.util.Arrays;
import java.util.Random;

public class RadixSort {
  public static void radixSort(int[] arr) {
    if (arr.length < 2) return;

    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > max) max = arr[i];
    }

    // 从个位开始
    for (int exp = 1; max / exp > 0; exp *= 10) {
      countingSort(arr, exp);
    }
  }


  private static void countingSort(int[] arr, int exp) {
    int[] count = new int[10];
    // 按位计算每个位大小出现的次数
    for (int i = 0; i < arr.length; i++) {
      count[(arr[i] / exp) % 10]++;
    }

    // 从左至右累加
    for (int i = 1; i < count.length; i++) {
      count[i] += count[i-1];
    }

    // 按位进行排序
    int[] temp = new int[arr.length];
    for (int i = arr.length-1; i >= 0; i--) {
      temp[--count[arr[i] / exp % 10]] = arr[i];
    }

    // 拷贝回原数组
    for (int i = 0; i < temp.length; i++) {
      arr[i] = temp[i];
    }
  }

  public static void main(String[] args) {
    Random random = new Random();
    int[] arr = new int[50];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = random.nextInt(123456789);
    }
    System.out.println("before:");
    System.out.println(Arrays.toString(arr));

    System.out.println("after:");
    radixSort(arr);
    System.out.println(Arrays.toString(arr));

  }
}
