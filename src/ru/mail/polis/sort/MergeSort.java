package ru.mail.polis.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort<T> extends AbstractSortOnComparisons<T> {
    @Override
    public void sort(T[] array) {
        mergeSort(array);
    }

    private void mergeSort(T[] array) {
        int n = array.length;
        T[] t = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length);
        for (int len = 1; len < n; len *= 2) {
            for (int left = 0; left < n - len; left += len + len) {
                int mid = left + len - 1;
                int right = Math.min(left + len + len - 1, n - 1);
                merge(array, t, left, mid, right);
            }
        }
    }

    private void merge(T[] arr, T[] t, int left,int mid,int right) {
        for (int i = left;i<= right;i++) {
            t[i]=arr[i];
        }
        int i = left, j=mid+1;
        for (int k = left;k<=right;k++) {
            if (i>mid) {
                arr[k]=t[j++];
            } else if (j > right) {
                arr[k] = t[i++];
            } else if (lesser(t[j],t[i])) {
                arr[k] = t[j++];
            } else {
                arr[k] = t[i++];
            }
        }
    }


}
