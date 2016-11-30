package com.geekhub.hw6.sorter;

public class SorterBySelection implements ArraySorter {

    public static Comparable[] sort(Comparable[] elements, Direction direction) {
        for (int a = 0; a < elements.length - 1; a++) {
            for (int b = a + 1; b < elements.length; b++) {
                if ((elements[b]).compareTo((elements[a])) * (direction.getValue()) < 0) {
                    Comparable temp = elements[b];
                    elements[b] = elements[a];
                    elements[a] = temp;
                }
            }
        }
        return elements;
    }
}
