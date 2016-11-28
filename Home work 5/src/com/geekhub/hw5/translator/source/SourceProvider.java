package com.geekhub.hw5.translator.source;

import java.io.IOException;

public interface SourceProvider {

    boolean isAllowed(String pathToSource) ;

    String load(String pathToSource) throws SourceLoadingException;
}