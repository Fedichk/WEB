package com.geekhub.hw6.sorter;

public class SorterByBuble implements ArraySorter {

    public static Comparable[] sort(Comparable[] elements, Direction direction) {
        if (direction == Direction.ASC) {
            for (int a = 1; a < elements.length; a++) {
                for (int b = 0; b < elements.length - a; b++) {
                    if (((elements[b]).compareTo((elements[b + 1]))) > 0) {
                        Comparable temp = elements[b];
                        elements[b] = elements[b + 1];
                        elements[b + 1] = temp;
                    }
                }
            }
        }
        if (direction == Direction.DESC) {
            for (int a = 1; a < elements.length; a++) {
                for (int b = 0; b < elements.length - a; b++) {
                    if (((elements[b]).compareTo((elements[b + 1]))) < 0) {
                        Comparable temp = elements[b];
                        elements[b] = elements[b + 1];
                        elements[b + 1] = temp;
                    }
                }
            }
        }
        return elements;
    }
}
