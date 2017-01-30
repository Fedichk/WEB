package com.geekhub.hw5.translator.source;

public interface SourceProvider {

    boolean isAllowed(String pathToSource) ;

    String load(String pathToSource) throws SourceLoadingException;
}