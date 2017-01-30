package com.geekhub.hw11.translator.source;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
@Component
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