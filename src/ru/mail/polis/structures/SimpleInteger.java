package ru.mail.polis.structures;

/**
 * Created by Nechaev Mikhail
 * Since 12/11/2017.
 */
public class SimpleInteger implements Numerical<SimpleInteger> {

    private static final int DIGIT_COUNT = 10;

    private final int data;
    private final int length;

    public SimpleInteger(Integer data) throws IllegalArgumentException {
        if (data == null) {
            throw new IllegalArgumentException("Source must be not null");
        }
        this.data = data;
        int tData = data, tLength = 1;
        while ((tData /= 10) > 0) { tLength++; }
        this.length=tLength;

    }

    @Override
    public int getDigit(int index) throws IndexOutOfBoundsException {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Negative index " + index);
        } else if (index >= getDigitCount()) {
            return 0;
        } else {
            return (int) ((data % Math.pow(10,index+1)) / Math.pow(10,index));
        }
    }




    @Override
    public int getDigitMaxValue() {
        return DIGIT_COUNT;
    }

    @Override
    public int getDigitCount() {
        return length;
    }

    @Override
    public int compareTo(SimpleInteger anotherSimpleInteger) {
        return Integer.compare(this.data, anotherSimpleInteger.data);
    }

    @Override
    public String toString() {
        return data+"";
    }
}
