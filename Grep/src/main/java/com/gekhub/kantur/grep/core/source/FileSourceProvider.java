package com.gekhub.kantur.grep.core.source;

import org.apache.commons.cli.CommandLine;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileSourceProvider implements SourceProvider {

    @Override
    public boolean isAllowed(CommandLine commandLine) {
        String pathToSource = commandLine.getOptionValue("f");
        try {
            return ((commandLine.hasOption("f") || commandLine.hasOption("file"))
                    && (new File(pathToSource).isFile()));
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public InputStream load(CommandLine commandLine) throws SourceLoadingException {
        String pathToSource = commandLine.getOptionValue("f");
        try {
            return new FileInputStream(pathToSource);
        } catch (IOException e) {
            throw new SourceLoadingException(e);
        }
    }
}