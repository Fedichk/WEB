package com.geekhub.hw6.translator.core.language;

import java.io.IOException;

public class LanguageDetectorException extends Exception {

    public LanguageDetectorException(String message, Throwable cause) {
        super(message, cause);
    }

    public LanguageDetectorException(IOException e) {

    }
}
