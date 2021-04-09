package BinarySearch;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 二分查找的四种变形
 *
 *  1. 查找第一个大于等于给定值的元素;
 *  2. 查找最后一个小于等于给定值的元素;
 *  3. 查找最后一个值等于给定值的元素;
 */

public class BinarySearchV {
    public static int bsearch1(int[] a, int target) {
        if (a == null || a.length == 0) return -1;

        int low = 0, high = a.length-1;
        while (low <= high) {
            int mid = low+((high-low)>>1);
            if (a[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == 0 || a[mid-1] < target) return mid;
                else high = mid-1;
            }
        }
        return -1;
    }

    public static int bsearch2(int[] a, int target) {
        if (a == null || a.length == 0) return -1;

        int low = 0, high = a.length-1;
        while (low <= high) {
            int mid = low+((high-low)>>1);
            if (a[mid] <= target) {
                if (low == high || a[mid+1] > target) return mid;
                else low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
    public static int bsearch3(int[] a, int target) {
        int low = 0, high = a.length-1;

        while (low <= high) {
            int mid = low+((high-low)>>1);
            int val = a[mid];

            if (val < target) {
                low = mid+1;
            } else if (val > target) {
                high = mid-1;
            } else {
                if (mid == a.length-1 || a[mid+1] > target) return mid;
                else low = mid+1;
            }
        }
        return -1;

    }


    public static void main(String[] args) {

        char c = 39532;
        System.out.println(c);

    }


}
