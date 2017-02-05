package com.gekhub.kantur.grep.core.handler;

import com.gekhub.kantur.grep.core.source.SourceLoadingException;

public interface TextHandler {

    String handling(String text) throws SourceLoadingException;
}