package ru.mail.polis.sort;

import java.util.Arrays;

public class QuickSort1<T> extends AbstractSortOnComparisons<T> {

    private final int QUICK_SORT_THRESHOLD = 15;

    @Override
    public void sort(T[] array) {
        quickSort(array,0,array.length-1);
    }

    private void quickSort(T[] array, int left, int right) {
        if (left >= right) { return; }

        if (right-left < QUICK_SORT_THRESHOLD) {
            insertionSort(array,left,right);
        } else {
            int idx = parition(array, left, right);
            quickSort(array, left, idx);
            quickSort(array, idx + 1, right);
        }
    }

    private int parition(T[] array, int left, int right) {
        T p = array[(int)(Math.random()*(right-left))+left];
        int i = left, j = right;
        while (i <= j) {
            while (lesser(array[i],p))  { i++; }
            while (greater(array[j],p)) { j--; }
            if (i <= j) { swap(array,i++,j--); }
        }
        return j;
    }

    private void insertionSort(T[] array, int left, int right) {

        for (int i = left+1; i <= right; i++) {
            for (int j = i; j>0 && lesser(array[j],array[j-1]);j--) {
                swap(array,j,j-1);
            }
        }
    }


}
