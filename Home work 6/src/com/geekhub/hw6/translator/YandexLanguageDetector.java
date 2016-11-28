package com.geekhub.hw6.translator;

import com.geekhub.hw6.translator.core.language.Language;
import com.geekhub.hw6.translator.core.language.LanguageDetector;
import com.geekhub.hw6.translator.core.language.LanguageDetectorException;
import com.geekhub.hw6.translator.core.language.UnknownLanguageException;
import com.geekhub.hw6.translator.util.EncodingUtils;
import com.geekhub.hw6.translator.util.IOUtils;

import java.io.IOException;
import java.net.URL;

public class YandexLanguageDetector implements LanguageDetector {

    private static final String YANDEX_LANGUAGE_DETECTOR_API_URL = "https://translate.yandex.net/api/v1.5/tr.json/detect?key=%s&text=%s";

    private final String apiKey;

    public YandexLanguageDetector(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public Language detect(String text) throws LanguageDetectorException {

        try {
            return Language.find(EncodingUtils.encode(IOUtils.toString(new URL(String.format(YANDEX_LANGUAGE_DETECTOR_API_URL, apiKey, text)).openStream()), "lang"));
        } catch (IOException | UnknownLanguageException e) {
            throw new LanguageDetectorException(e);
        }
    }
}