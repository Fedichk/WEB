package com.geekhub.hw6.translator;

import com.geekhub.hw6.translator.core.Translation;
import com.geekhub.hw6.translator.core.TranslationRequest;
import com.geekhub.hw6.translator.core.Translator;
import com.geekhub.hw6.translator.core.TranslatorException;
import com.geekhub.hw6.translator.core.language.Language;
import com.geekhub.hw6.translator.core.language.LanguageDetector;
import com.geekhub.hw6.translator.core.language.LanguageDetectorException;
import com.geekhub.hw6.translator.util.EncodingUtils;
import com.geekhub.hw6.translator.util.IOUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class YandexTranslator implements Translator {

    private static final String YANDEX_TRANSLATOR_API_URL = "https://translate.yandex.net/api/v1.5/tr.json/translate?key=%s&text=%s&lang=%s";

    private final String apiKey;
    private final LanguageDetector languageDetector;

    public YandexTranslator(String apiKey, LanguageDetector languageDetector) {
        this.apiKey = apiKey;
        this.languageDetector = languageDetector;
    }

    @Override
    public Translation translate(TranslationRequest translationRequest) throws TranslatorException {
        String fullURL = null;
        try {
            fullURL = String.format(YANDEX_TRANSLATOR_API_URL, apiKey,
                    translationRequest.getText(),
                    prepareLanguageDirection(languageDetector.detect(translationRequest.getText()), translationRequest.getTargetLanguage()));
        } catch (LanguageDetectorException e) {
            e.printStackTrace();
        }
        URL url = null;
        try {
            url = new URL(fullURL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Translation translation = null;
        try {
            translation = new Translation(translationRequest.getText(), languageDetector.detect(translationRequest.getText()), EncodingUtils.encode(IOUtils.toString(url.openStream()), "text"), translationRequest.getTargetLanguage());
        } catch (LanguageDetectorException e) {
            System.out.println("Something went wrong during translating");
        } catch (IOException e) {
            e.printStackTrace();
        }


        return translation;
    }

    private String prepareLanguageDirection(Language from, Language to) {
        return from.getCode() + "-" + to.getCode();
    }
}
