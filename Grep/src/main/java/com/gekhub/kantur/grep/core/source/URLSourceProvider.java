package com.gekhub.kantur.grep.core.source;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class URLSourceProvider implements SourceProvider {

    @Override
    public InputStream load(String pathToSource) throws SourceLoadingException {
        try {
            return new URL(pathToSource).openStream();
        } catch (IOException e) {
            throw new SourceLoadingException(e);
        }
    }
}