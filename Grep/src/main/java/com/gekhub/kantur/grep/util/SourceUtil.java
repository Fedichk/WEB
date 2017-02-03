package com.gekhub.kantur.grep.util;

import com.gekhub.kantur.grep.core.source.SourceLoadingException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SourceUtil {
    public String toString(InputStream in, String args) throws SourceLoadingException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line;
            Pattern pattern = Pattern.compile(args);
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line.toLowerCase());
                if (matcher.find()) {
                    content.append(args).append(System.getProperty("line.separator"));
                    content.append(line).append(System.getProperty("line.separator"));
                }
            }
        } catch (IOException e) {
            throw new SourceLoadingException(e);
        }
        return String.valueOf(content);
    }
}