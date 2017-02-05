package com.gekhub.kantur.grep.core.source;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileSourceProvider implements SourceProvider {

    private String pathToSource;

    public FileSourceProvider(String pathToSource) {
        this.pathToSource = pathToSource;
    }

    @Override
    public String load() throws SourceLoadingException {
        try {
            return FileUtils.readFileToString(new File(pathToSource), "UTF-8");
        } catch (IOException e) {
            throw new SourceLoadingException(e);
        }
    }
}