package com.geekhub.hw5.translator.source;

import java.io.*;
import java.net.URL;

public class FileSourceProvider implements SourceProvider {

    @Override
    public boolean isAllowed(String pathToSource) {
        return new File(pathToSource).isFile();
    }

    @Override
    public String load(String pathToSource) throws SourceLoadingException {
        try {
            return SourceUtil.toString(new FileInputStream(pathToSource));
        } catch (IOException e) {
            throw new SourceLoadingException(e);
        }
    }
}