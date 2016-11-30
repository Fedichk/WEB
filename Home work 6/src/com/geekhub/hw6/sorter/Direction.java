package com.geekhub.hw6.sorter;

public enum Direction {
    ASC(1),
    DESC(-1);

    private final int i;

    Direction(int i) {
        this.i = i;
    }

    public int getValue() {
        return i;
    }
}
