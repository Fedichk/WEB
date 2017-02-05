package com.gekhub.kantur.grep.core.source;

public interface SourceProvider {

    String load() throws SourceLoadingException;
}