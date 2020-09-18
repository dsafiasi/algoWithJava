package com.jdbc.AboutArray;


import java.util.Arrays;

/**
 * 1. 数组的插入与删除操作；根据下标随机访问
 * 2. 数组中的元素是int类型
 */
public class Array {
    private int[] data;
    private int count;

    private int capacity;

    public Array(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.data = new int[capacity];
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > count) {
            System.out.println("插入的位置不合法");
            return false;
        }

        // 容量已满
        if (count == capacity) {
            System.out.println("已满");
            return false;
        }


        // 搬迁
        for (int i = count; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = value;
        count++;
        return true;
    }

    public boolean delete(int index) {
        if (index < 0 || index >= count) {
            return false;
        }

        for (int i = index; i < count-1; i++) {// 此处会出bug，因为当count==capacity时，会越界,因此不能这么写
            data[i] = data[i+1];
        }

        count--;
        return true;
    }


    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        int[] a = new int[10];
//        System.out.println(Arrays.toString(a));
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);// 4、5、3、10、9
        array.insert(3, 9);
        array.insert(3, 10);
//        System.out.println(array.insert(3, 11));
        array.printAll();
        array.delete(3);
        array.printAll();

        array.delete(3);
        array.printAll();


    }

}
