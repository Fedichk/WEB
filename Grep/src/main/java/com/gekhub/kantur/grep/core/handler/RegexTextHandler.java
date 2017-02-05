package com.gekhub.kantur.grep.core.handler;

import com.gekhub.kantur.grep.core.source.SourceLoadingException;
import com.gekhub.kantur.grep.util.TextHandlingUtil;

public class RegexTextHandler implements TextHandler {

    private String args;

    public RegexTextHandler(String args) {
        this.args = args;
    }

    @Override
    public String handling(String text) throws SourceLoadingException {
        return new TextHandlingUtil().starsAdding(new TextHandlingUtil().textFiltering(text, args),args);
    }
}