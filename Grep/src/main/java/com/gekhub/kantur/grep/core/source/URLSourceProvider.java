package com.gekhub.kantur.grep.core.source;

import org.apache.commons.cli.CommandLine;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class URLSourceProvider implements SourceProvider {

    @Override
    public boolean isAllowed(CommandLine commandLine ) {
        String pathToSource = commandLine.getOptionValue("u");
        try {
            new URL(pathToSource);
            return (commandLine.hasOption("u") || commandLine.hasOption("url"));
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public InputStream load(CommandLine commandLine) throws SourceLoadingException {
        String pathToSource = commandLine.getOptionValue("u");
        try {
            return new URL(pathToSource).openStream();
        } catch (IOException e) {
            throw new SourceLoadingException(e);
        }
    }
}