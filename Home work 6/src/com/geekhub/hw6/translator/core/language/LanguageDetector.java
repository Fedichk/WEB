package com.geekhub.hw6.translator.core.language;

public interface LanguageDetector {

    Language detect(String text) throws LanguageDetectorException;
}
