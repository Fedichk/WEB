package com.gekhub.kantur.grep.core.source;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileSourceProvider implements SourceProvider {

    @Override
    public InputStream load(String pathToSource) throws SourceLoadingException {
        try {
            return new FileInputStream(pathToSource);
        } catch (IOException e) {
            throw new SourceLoadingException(e);
        }
    }
}