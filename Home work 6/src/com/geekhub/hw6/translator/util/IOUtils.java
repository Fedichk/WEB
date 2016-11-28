package com.geekhub.hw6.translator.util;

import com.geekhub.hw6.translator.core.TranslatorException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOUtils {

    private IOUtils() {
    }

    public static String toString(InputStream in) throws IOException {

        StringBuilder content = new StringBuilder();
        try {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                }
            }
        } catch (IOException e) {
            new TranslatorException(e);
        }
        return String.valueOf(content);
    }
}
