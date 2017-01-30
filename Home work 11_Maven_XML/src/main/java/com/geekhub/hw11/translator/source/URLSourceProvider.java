package com.geekhub.hw11.translator.source;

import java.io.IOException;
import java.net.URL;

public class URLSourceProvider implements SourceProvider {

    @Override
    public boolean isAllowed(String pathToSource) {
        try {
            new URL(pathToSource);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String load(String pathToSource) throws SourceLoadingException {
        try {
            return SourceUtil.toString(new URL(pathToSource).openStream());
        } catch (IOException e) {
            throw new SourceLoadingException(e);
        }
    }
}

