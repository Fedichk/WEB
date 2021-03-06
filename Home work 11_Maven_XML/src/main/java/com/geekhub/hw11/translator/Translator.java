package com.geekhub.hw11.translator;

import com.geekhub.hw11.translator.source.SourceLoadingException;
import com.geekhub.hw11.translator.source.URLSourceProvider;

import java.io.IOException;
import java.net.URLEncoder;

public class Translator {

    private static final String YANDEX_API_KEY = "trnsl.1.1.20131116T095927Z.86fe567e8de2cf44.5be1510f166cd444fdd9363db18bb3b5537bb7e9";
    private static final String TRANSLATION_DIRECTION = "ru";
    private URLSourceProvider urlSourceProvider;

    public Translator(URLSourceProvider urlSourceProvider)

    {
        this.urlSourceProvider = urlSourceProvider;
    }

    public String translate(String original) throws TranslateException, SourceLoadingException {
        try {
            return parseContent(urlSourceProvider.load(prepareURL(original)));
        } catch (IOException e) {
            throw new TranslateException(e);
        }
    }

    private String prepareURL(String text) throws IOException {
        return "https://translate.yandex.net/api/v1.5/tr/translate?key=" + YANDEX_API_KEY + "&text=" + encodeText(text) + "&lang=" + TRANSLATION_DIRECTION;
    }

    private String parseContent(String content) {
        int start = (content.indexOf("<text>")) + 6;
        int end = content.indexOf("</text>");
        return content.substring(start, end);
    }

    private String encodeText(String text) throws IOException {
        return URLEncoder.encode(text, "UTF-8");
    }
}