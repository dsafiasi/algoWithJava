import java.util.ArrayList;

public class Test<E> {
    private E[] array;
    private int last = 0;
    private int first = 0;
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;

    public Test() {
        this.capacity = DEFAULT_CAPACITY;
        this.array = (E[]) new Object[capacity];
    }

    public Test(int capacity) {
        this.capacity = capacity;
        this.array = (E[]) new Object[capacity];
    }

    public boolean enque(E e) {
        if (last == capacity) {
            if (first != 0) {
                update();
            } else return false;
        }
        array[last++] = e;
        return true;
    }

    public E deque() {
        if (first == last) return null;
        return array[first++];
    }
    private void update() {
        int j = 0;
        for (int i = first; i < last; i++) {
            array[j++] = array[i];
        }
        first = 0;
        last = j;
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        a[0] = 1;
        System.out.println(a.length);
//        ArrayList<String> list = new ArrayList<>();
//        list.add("a");
//        list.add(2, "b");

    }

}
