package com.gekhub.kantur.grep.core.source;

import java.io.InputStream;

public interface SourceProvider {

    InputStream load(String pathToSource) throws SourceLoadingException;
}