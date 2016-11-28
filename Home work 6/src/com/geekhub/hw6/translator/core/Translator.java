package com.geekhub.hw6.translator.core;

public interface Translator {

    Translation translate(TranslationRequest translationRequest) throws TranslatorException;
}
