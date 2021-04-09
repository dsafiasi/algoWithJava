package List;


/**
 * contains(T value)
 * get(int index)
 * indexOf(T value)
 * add(index,e)
 * addFirst、addLast、remove、removeFirst、removeLast、removeElement、resize
 * set
 *         checkIndexForAdd(index);
 */
public class GenericArray <T>{
    private final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private T[]data;
    private int count;


    public GenericArray() {
        this.capacity = DEFAULT_CAPACITY;
        this.data =(T[]) new Object[DEFAULT_CAPACITY];
        this.count = 0;
    }

    public GenericArray(int capacity) {
        this.capacity = capacity;
        this.data =(T[]) new Object[capacity];
        this.count = 0;
    }


    public T removeElement(T value) {
        int index= indexOf(value);
        if (index != -1) {
            return remove(index);
        } else {
            return null;
        }
    }

    public T removeLast() {
        return remove(count-1);
    }
    public T removeFirst() {
        return remove(0);
    }


    // 修改 index 位置的元素
    public void set(int index, T newVal) {
        checkIndex(index);
        data[index] = newVal;
    }

    public int indexOf(T value) {
        for (int i = 0; i < count; i++) {
            if (data[i].equals(value)) return i;
        }

        return -1;
    }

    public int getCapacity() {
        return capacity;
    }

    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array count = %d, capacity = %d \n", count, data.length));
        builder.append('[');
        for (int i = 0; i < count; i++) {
            builder.append(data[i]);
            if (i != count - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }

    public boolean contains(T value) {
        for (int i = 0; i < count; i++) {
            if (data[i].equals(value)) return true;
        }

        return false;
    }

    private void resize(int newCapacity) {
        T[] newArray = (T[]) new Object[newCapacity];

        for (int i = 0; i < data.length; i++) {
            newArray[i] = data[i];
        }
        data = newArray;

        capacity = newCapacity;
    }

    public T remove(int index) {
        checkIndex(index);
        T deleteElement = data[index];

        for (int i = index; i < count-1; i++) {
            data[i] = data[i+1];
        }
        count--;

//        // 缩容
        if (count <= capacity/4 && data.length/2 != 0) {// 有超过3/4空闲空间，并且length ！= 1
            resize(capacity/2 );
        }

        return deleteElement;
    }


    public boolean add(int index, T value) {
        checkIndexForAdd(index);

        if (count == capacity) {
            resize(2 * capacity);
        }

        for (int i = count; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = value;
        count++;
        return true;
    }

    public boolean addLast(T value) {
        return add(count, value);
    }

    public boolean addFirst(T value) {
        return add(0,value);
    }


    private void checkIndex(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Add failed! Require index >=0 and index < size.");
        }
    }

    private void checkIndexForAdd(int index) {
        if(index < 0 || index > count) {
            throw new IllegalArgumentException("remove failed! Require index >=0 and index <= size.");
        }
    }


}
