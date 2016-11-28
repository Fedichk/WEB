package com.geekhub.hw5.archivator.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileSorter {

    public List<File> fileSorting(File path, String... extensions) {

        List<File> files = new ArrayList<>();

        if (path.isDirectory()) {
            for (File file : path.listFiles()) {
                files.addAll(fileSorting(file, extensions));
            }
        }

        if (path.isFile()) {
            for (String ext : extensions) {
                if (path.getName().endsWith(ext)) {
                    files.add(path);
                }
            }
        }
        return files;
    }
}