package com.geekhub.hw5.archivator.utils;

public enum FileType {
    AUDIO(".mp3", ".wav", ".wma"),
    VIDEO(".avi", ".mp4", ".flv", ".mkv"),
    IMAGE(".jpeg", ".jpg", ".gif", ".png");

    String[] extensions;

    FileType(String... extensions) {
        this.extensions = extensions;
    }

    public String[] getExtensions() {
        return extensions;
    }
}
