package com.geekhub.hw11.translator.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SourceLoader {

    @Autowired
    private List<SourceProvider> sourceProviders;

    public String loadSource(String pathToSource) throws SourceLoadingException {
        for (SourceProvider provider : sourceProviders) {
            if (provider.isAllowed(pathToSource)) {
                return provider.load(pathToSource);
            }
        }
        return null;
    }
}