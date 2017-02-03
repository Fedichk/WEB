package com.gekhub.kantur.grep.core.handler;

import com.gekhub.kantur.grep.core.source.SourceLoadingException;
import org.apache.commons.cli.CommandLine;

public interface TextHandler {

    boolean isAllowed(CommandLine commandLine);

    String handling(CommandLine commandLine) throws SourceLoadingException;
}