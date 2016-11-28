package com.geekhub.hw4.taskmanager;

class Task {

    private String name;
    private String category;

    private Task(String name, String category) {
        this.name = name;
        this.category = category;
    }

    String getName() {

        return name;
    }

    String getCategory() {

        return category;
    }
}
