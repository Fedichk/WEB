package com.geekhub.hw6.sorter;

public class SorterByInsertion implements ArraySorter {

    public static Comparable[] sort(Comparable[] elements, Direction direction) {
        for (int a = 0; a < elements.length; a++) {
            for (int b = a; b > 0; b--) {
                if (((elements[b]).compareTo((elements[b - 1]))) * (direction.getValue()) < 0) {
                    Comparable temp = elements[b];
                    elements[b] = elements[b - 1];
                    elements[b - 1] = temp;
                }
            }
        }
        return elements;
    }
}
