package com.gekhub.kantur.grep.core.source;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;

public class URLSourceProvider implements SourceProvider {

    private String pathToSource;

    public URLSourceProvider(String pathToSource) {
        this.pathToSource = pathToSource;
    }

    @Override
    public String load() throws SourceLoadingException {
        try {
            return IOUtils.toString(new URL(pathToSource), "UTF-8");
        } catch (IOException e) {
            throw new SourceLoadingException(e);
        }
    }
}