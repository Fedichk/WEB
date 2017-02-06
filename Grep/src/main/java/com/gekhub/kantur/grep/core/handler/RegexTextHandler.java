package com.gekhub.kantur.grep.core.handler;

import com.gekhub.kantur.grep.util.TextHandlingUtil;

public class RegexTextHandler implements TextHandler {

    private String args;
    private TextHandlingUtil textHandlingUtil = new TextHandlingUtil();

    public RegexTextHandler(String args) {
        this.args = args;
    }

    @Override
    public String handling(String text) {
        String filtredText = textHandlingUtil.filterText(text, args);
        return new TextHandlingUtil().addStars(filtredText, args);
    }
}