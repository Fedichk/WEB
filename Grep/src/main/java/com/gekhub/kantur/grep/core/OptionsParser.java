package com.gekhub.kantur.grep.core;

import com.gekhub.kantur.grep.core.handler.RegexTextHandler;
import com.gekhub.kantur.grep.core.handler.TextHandler;
import com.gekhub.kantur.grep.core.handler.WordTextHandler;
import com.gekhub.kantur.grep.core.source.FileSourceProvider;
import com.gekhub.kantur.grep.core.source.SourceLoadingException;
import com.gekhub.kantur.grep.core.source.SourceProvider;
import com.gekhub.kantur.grep.core.source.URLSourceProvider;
import org.apache.commons.cli.CommandLine;

public class OptionsParser {

    public SourceProvider parseSource(CommandLine commandLine) throws SourceLoadingException {
        if (commandLine.hasOption("f") || commandLine.hasOption("file")) {
            return new FileSourceProvider(commandLine.getOptionValue("f"));
        } else if (commandLine.hasOption("u") || commandLine.hasOption("url")) {
            return new URLSourceProvider(commandLine.getOptionValue("u"));
        }
        return null;
    }

    public TextHandler parseArgument(CommandLine commandLine) {
        if (commandLine.hasOption("r") || commandLine.hasOption("regex")) {
            return new RegexTextHandler(commandLine.getOptionValue("r"));
        } else if (commandLine.hasOption("w") || commandLine.hasOption("word")) {
            return new WordTextHandler(commandLine.getOptionValue("w"));
        }
        return null;
    }
}