package com.gekhub.kantur.grep.core.handler;

import com.gekhub.kantur.grep.core.source.SourceLoadingException;
import com.gekhub.kantur.grep.util.TextHandlingUtil;

import java.io.InputStream;

public class WordTextHandler implements TextHandler {

    private String args;

    public WordTextHandler(String args) {
        this.args = args;
    }

    @Override
    public String handling(InputStream inputStream) throws SourceLoadingException {
        return new TextHandlingUtil().toString(inputStream, args);
    }
}