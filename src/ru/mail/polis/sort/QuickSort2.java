package ru.mail.polis.sort;

import java.util.Arrays;

public class QuickSort2<T> extends AbstractSortOnComparisons<T> {


    @Override
    public void sort(T[] array) {
        quickSort(array,0,array.length-1);
    }

    private void quickSort(T[] array, int left, int right) {
        if (right<=left) return;

        int lt=left;
        int gt=right;
        int i=left;

        int pi=(int)(Math.random()*(right-left))+left;
        T p=array[pi];


        while (i<=gt){

            if (lesser(array[i],p)){
                swap(array, i++, lt++);
            }
            else if (lesser (p, array[i])){
                swap(array, i, gt--);
            }
            else{
                i++;
            }
        }

        quickSort (array, left, lt-1);
        quickSort (array, gt+1, right);



    }





}
