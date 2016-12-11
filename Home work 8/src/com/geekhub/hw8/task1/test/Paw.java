package com.geekhub.hw8.task1.test;

import com.geekhub.hw8.task1.json.Ignore;
import com.geekhub.hw8.task1.json.adapter.ColorAdapter;
import com.geekhub.hw8.task1.json.adapter.UseDataAdapter;

import java.awt.*;

public class Paw {

    @Ignore
    private Integer length;

    @UseDataAdapter(ColorAdapter.class)
    private Color color;

    public Paw(Integer length, Color color) {
        this.length = length;
        this.color = color;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}