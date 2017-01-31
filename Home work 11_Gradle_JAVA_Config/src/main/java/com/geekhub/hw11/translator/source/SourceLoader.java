package com.geekhub.hw11.translator.source;

import java.util.List;

public class SourceLoader {

    private List<SourceProvider> sourceProviders;

    public SourceLoader(List<SourceProvider> sourceProviders) {
        this.sourceProviders = sourceProviders;
    }

    public String loadSource(String pathToSource) throws SourceLoadingException {
        for (SourceProvider provider : sourceProviders) {
            if (provider.isAllowed(pathToSource)) {
                return provider.load(pathToSource);
            }
        }
        return null;
    }
}