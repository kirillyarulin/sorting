package ru.mail.polis.sort;

import java.util.Arrays;

public class QuickSort2<T> extends AbstractSortOnComparisons<T> {


    @Override
    public void sort(T[] array) {
        quickSort(array,0,array.length-1);
    }

    private void quickSort(T[] array, int left, int right) {
        if (left >= right) { return; }



        T v = array[(int)(Math.random()*(right-left))+left];
        int i = left, j = right;
        int p = left-1, q = right+1;

        while (true) {
            while (lesser(array[i++],v));// { i++; }
            while (greater(array[j--],v));// { j--; }
            if (i==j) { break; }
            if (i>=j) { break; }
            swap(array,i,j);
            if (array[i] == v) {
                p++;
                swap(array,p,i);
            }
            if (array[j] == v) {
                q--;
                swap(array,q,j);
            }

        }
        swap(array,i,right);
        j = i - 1;
        i++;
        for (int k = 0; k <= p; k++,j--) { swap(array,k,j); }
        for (int k = right+1; k > q; k--,i++) { swap(array,k,i); }

        quickSort(array,0,j);
        quickSort(array,i,right);



    }





}
