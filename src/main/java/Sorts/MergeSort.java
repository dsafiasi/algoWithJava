package Sorts;

import java.util.Arrays;

public class MergeSort {


    public static void mergeSort(int[] a, int n) {mergeSortInternally(a, 0, n-1);}

    private static void mergeSortInternally(int[] a, int p,int r) {

        if (p >= r) return;

        // 防止p+r的大小超过int的最大值
        int q = p + (r-p)/2;

        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q+1, r);
        merge(a, p, q, r);
    }

    private static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q+1;
        int k = 0;
        int[] temp = new int[r-p+1];
        while (i<=q && j<=r) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }


        // 正确写法
        while (start <= end) {
            temp[k++] = a[start++];
        }

        // 错误写法。
        // 此处的问题出在，k<end-start+1，k并不等于0，此处遍历次数为！=end-start+1次，而是end-start+1-k(初始k)次
//        for (; k < end-start+1; k++) {
//            temp[k] = a[start++];
//        }


        // 正确
        for (i = 0; i <= r-p; ++i) {
            a[p+i] = temp[i];
        }


        //错误
        // 此处的问题同样，此处遍历r-p+1-p次，而我们希望的是遍历r-p+1次，因此，应该改为：r+1
        // 此时，测试通过
//        for (int t = p; t < r+1; t++) {
//            a[t] = temp[t-p];
//        }



    }

    public static void main(String[] args) {
        int[] toSorts = {222,34,11,33,221,4456,0};
        MergeSort.mergeSort(toSorts, toSorts.length);

        System.out.println(Arrays.toString(toSorts));
    }

}
