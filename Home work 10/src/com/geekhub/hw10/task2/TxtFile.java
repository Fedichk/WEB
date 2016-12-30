package com.geekhub.hw10.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;

public class TxtFile {

    public Collection<String> getPageLinks(String folder) throws IOException {
        return Files.readAllLines(Paths.get(folder)) ;
    }
}
