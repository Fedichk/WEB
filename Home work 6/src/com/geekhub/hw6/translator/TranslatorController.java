package com.geekhub.hw6.translator;

import com.geekhub.hw6.translator.core.Translation;
import com.geekhub.hw6.translator.core.TranslationRequest;
import com.geekhub.hw6.translator.core.Translator;
import com.geekhub.hw6.translator.core.TranslatorException;
import com.geekhub.hw6.translator.core.language.Language;
import com.geekhub.hw6.translator.core.language.LanguageDetector;
import com.geekhub.hw6.translator.core.language.LanguageDetectorException;
import com.geekhub.hw6.translator.core.language.UnknownLanguageException;

import java.io.IOException;
import java.util.Scanner;

public class TranslatorController {

    public static void main(String[] args) throws LanguageDetectorException, IOException {
        LanguageDetector languageDetector = new YandexLanguageDetector("trnsl.1.1.20131116T095927Z.86fe567e8de2cf44.5be1510f166cd444fdd9363db18bb3b5537bb7e9");
        Translator translator = new YandexTranslator("trnsl.1.1.20131116T095927Z.86fe567e8de2cf44.5be1510f166cd444fdd9363db18bb3b5537bb7e9", languageDetector);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String text = scanner.nextLine();
            if ("exit".equals(text)) {
                break;
            }

            try {
                String targetLanguage = scanner.nextLine();
                TranslationRequest translationRequest = new TranslationRequest(text, Language.find(targetLanguage));
                Translation translation = translator.translate(translationRequest);

                System.out.println("Original text: " + translation.getOriginalText());
                System.out.println("Original language: " + translation.getOriginalLanguage());

                System.out.println("Translated text: " + translation.getTranslatedText());
                System.out.println("Target language: " + translation.getTargetLanguage());
            } catch (UnknownLanguageException e) {
                System.out.println("Language '" + e.getUnknownLanguage() + "' is not supported yet");
                break;
            } catch (TranslatorException e) {
                System.out.println("Something went wrong during translating");
                break;
            }
        }
    }
}
