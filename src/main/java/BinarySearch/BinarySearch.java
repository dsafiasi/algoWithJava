package BinarySearch;

public class BinarySearch {

    public static int bsearchRecursion(int[] a, int target) {
        return bsearchRecursion(a, target, 0, a.length-1);
    }

    // 递归写法
    private static int bsearchRecursion(int[] a, int target, int low, int high) {
        if (low > high) return -1;
        int mid = low+((high-low)>>1);
        if (a[mid] < target) {
            return bsearchRecursion(a, target, mid+1, high);
        } else if (a[mid] > target) {
            return bsearchRecursion(a, target, low, mid-1);
        } else {
            return mid;
        }
    }


    // 非递归写法
    public static int bsearch(int[] a, int target) {
        if (a == null || a.length == 0)return -1;
        int low = 0, high = a.length-1;
        while (low <= high) {
            int mid = low+((high-low)>>1);
            int val = a[mid];
            if (val < target) {
                low = mid+1;
            } else if (val > target) {
                high = mid-1;
            } else {
                return mid;
            }
        }
        return -1;
    }






    public static void main(String[] args) {
        int[] a = {1,4,6,7,9,10,11,13,19,30,77};
        int index = bsearchRecursion(a, 77);
        if (index < 0) {
            System.out.println("not found");
        } else {
            System.out.println("index:"+index + "  val:" + a[index]);
        }
    }

}
