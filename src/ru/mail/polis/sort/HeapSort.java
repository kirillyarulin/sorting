package ru.mail.polis.sort;

import java.util.Arrays;

public class HeapSort<T> extends AbstractSortOnComparisons<T> {

    @Override
    public void sort(T[] array) {
        int heapSize=array.length;
        buildHeap(array,heapSize);
        while (heapSize > 1) {
            swap(array, 0, heapSize - 1);
            heapSize--;
            siftDown(array, 0,heapSize);
        }
    }

    private  void buildHeap(T[] array,int heapSize) {
        for (int i = array.length / 2; i >= 0; i--) {
            siftDown(array, i,heapSize);
        }
    }



    private void siftDown(T[] array, int i,int heapSize) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < heapSize &&  lesser(array[i], array[l])) {
            largest = l;
        }
        if (r < heapSize && lesser(array[largest], array[r])) {
            largest = r;
        }
        if (i != largest) {
            swap(array, i, largest);
            siftDown(array, largest,heapSize);
        }
    }

    private static int right(int i) {
        return 2 * i + 1;
    }

    private static int left(int i) {
        return 2 * i + 2;
    }

}
