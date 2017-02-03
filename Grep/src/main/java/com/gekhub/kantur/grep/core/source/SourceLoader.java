package com.gekhub.kantur.grep.core.source;

import org.apache.commons.cli.CommandLine;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SourceLoader {

    private List<SourceProvider> sourceProviders = new ArrayList<>();

    public SourceLoader(List<SourceProvider> sourceProviders) {
        this.sourceProviders = sourceProviders;
    }

    public InputStream loadSource(CommandLine commandLine) throws SourceLoadingException {
        for (SourceProvider provider : sourceProviders) {
            if (provider.isAllowed(commandLine)) {
                return provider.load(commandLine);
            }
        }
        return null;
    }
}