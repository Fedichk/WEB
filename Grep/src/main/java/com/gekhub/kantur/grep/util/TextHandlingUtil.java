package com.gekhub.kantur.grep.util;

import com.gekhub.kantur.grep.core.source.SourceLoadingException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextHandlingUtil {

    public String filterText(String text, String args) {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new StringReader(text));
        String line;
        Pattern pattern = Pattern.compile(args.toLowerCase());
        try {
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line.toLowerCase());
                if (matcher.find()) {
                    content.append(args).append(System.getProperty("line.separator"));
                    content.append(line).append(System.getProperty("line.separator"));
                }
            }
        } catch (IOException e) {
            new SourceLoadingException(e);
        }
        return String.valueOf(content);
    }

    public String addStars(String text, String args) {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new StringReader(text));
        String line;
        Pattern pattern = Pattern.compile(args.toLowerCase());
        try {
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line.toLowerCase());
                if (matcher.find()) {
                    content.append(line.replace(args, "*" + args + "*")).
                            append(System.getProperty("line.separator")
                            );
                }
            }
        } catch (IOException e) {
            new SourceLoadingException(e);
        }
        return String.valueOf(content);
    }
}