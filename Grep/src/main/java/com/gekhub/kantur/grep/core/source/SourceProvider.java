package com.gekhub.kantur.grep.core.source;

import org.apache.commons.cli.CommandLine;

import java.io.InputStream;

public interface SourceProvider {

    boolean isAllowed(CommandLine commandLine);

    InputStream load(CommandLine commandLine) throws SourceLoadingException;
}