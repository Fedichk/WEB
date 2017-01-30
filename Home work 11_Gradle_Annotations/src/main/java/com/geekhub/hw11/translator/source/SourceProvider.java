package com.geekhub.hw11.translator.source;

public interface SourceProvider {

    boolean isAllowed(String pathToSource) ;

    String load(String pathToSource) throws SourceLoadingException;
}