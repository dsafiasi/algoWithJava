package Heap;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    private List<HeapElement> maxHeap;

    public MaxHeap(List<HeapElement> listElements) {
        if (listElements == null) throw new NullPointerException();

        maxHeap = new ArrayList<>();
        for (HeapElement heapElement : listElements) {
            if (heapElement != null) insertElement(heapElement);
            else System.out.println("Null element. Not added to heap");
        }
        if (maxHeap.size() == 0) System.out.println("No element has been added, empty heap.");
    }

    public void insertElement(HeapElement heapElement) {
        maxHeap.add(heapElement);
        toggleUp(maxHeap.size());
    }


    private void swap(int index1, int index2) {
        HeapElement tempElement = maxHeap.get(index1-1);
        maxHeap.set(index1-1, maxHeap.get(index2-1));
        maxHeap.set(index2-1, tempElement);
    }

    private void toggleUp(int elementIndex) {
        double key = maxHeap.get(elementIndex-1).getKey();


    }


}
