package com.geekhub.hw11.translator.source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SourceUtil {
    static String toString(InputStream in) throws SourceLoadingException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            throw new SourceLoadingException(e);
        }
        return String.valueOf(content);
    }
}