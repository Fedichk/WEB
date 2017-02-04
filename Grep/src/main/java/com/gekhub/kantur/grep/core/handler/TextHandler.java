package com.gekhub.kantur.grep.core.handler;

import com.gekhub.kantur.grep.core.source.SourceLoadingException;

import java.io.InputStream;

public interface TextHandler {

    String handling(InputStream inputStream) throws SourceLoadingException;
}