package com.gekhub.kantur.grep.core.handler;

import com.gekhub.kantur.grep.core.LoadersCreator;
import com.gekhub.kantur.grep.core.source.SourceLoadingException;
import com.gekhub.kantur.grep.util.SourceUtil;
import org.apache.commons.cli.CommandLine;

public class RegexTextHandler implements TextHandler {
    @Override
    public boolean isAllowed(CommandLine commandLine) {
        return (commandLine.hasOption("r") || commandLine.hasOption("regex"));
    }

    @Override
    public String handling(CommandLine commandLine) throws SourceLoadingException {
        return new SourceUtil().toString(
                new LoadersCreator().sourceLoaderCreate().loadSource(commandLine),
                commandLine.getOptionValue("r")
        );
    }
}