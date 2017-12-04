package ru.mail.polis.sort;

import ru.mail.polis.structures.Numerical;
import ru.mail.polis.structures.SimpleInteger;

import java.lang.reflect.Array;

/**
 * Created by Nechaev Mikhail
 * Since 27/11/2017.
 */
public class LSDSort<T extends Numerical> implements Sort<T> {

    public LSDSort() {
        /* empty */
    }

    @Override
    public void sort(T[] array) {
        final int r = array[0].getDigitMaxValue()+1;
        int d = array[0].getDigitCount();
        for (T x : array) {
            if (x.getDigitCount()>d) { d = x.getDigitCount(); }
        }
        for (int k = 0; k < d; k++) {
            int[] count = new int[r];
            for (T x : array) {
                count[x.getDigit(k)]++;
            }
            for (int i = 1; i < r; i++) {
                count[i] += count[i - 1];
            }
            T[] res = (T[]) Array.newInstance(array.getClass().getComponentType(),array.length);
            for (int i = array.length - 1; i >= 0; i--) {
                res[--count[array[i].getDigit(k)]] = array[i];
            }
            System.arraycopy(res, 0, array, 0, array.length);
        }
    }

    public static void main(String[] args) {
        SimpleInteger[] simpleInteger = new SimpleInteger[10];
        simpleInteger[0] = new SimpleInteger(345);
        simpleInteger[1] = new SimpleInteger(3);
        simpleInteger[2] = new SimpleInteger(76);
        simpleInteger[3] = new SimpleInteger(567);
        simpleInteger[4] = new SimpleInteger(756);
        simpleInteger[5] = new SimpleInteger(355);
        simpleInteger[6] = new SimpleInteger(345);
        simpleInteger[7] = new SimpleInteger(44);
        simpleInteger[8] = new SimpleInteger(345);
        simpleInteger[9] = new SimpleInteger(54);
        LSDSort<SimpleInteger> q = new LSDSort<>();
        q.sort(simpleInteger);
        for (SimpleInteger x : simpleInteger) {
            System.out.print(x + " ");
        }
    }

}
