package Heap;

public class HeapElement {
    private final double key;
    private final Object additionalInfo;

    public HeapElement(double key, Object info) {
        this.key = key;
        this.additionalInfo = info;
    }

    public Object getInfo() {
        return additionalInfo;
    }

    public double getKey() {
        return key;
    }

}
