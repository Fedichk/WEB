package com.gekhub.kantur.grep.core;

import com.gekhub.kantur.grep.core.handler.HandlerLoader;
import com.gekhub.kantur.grep.core.handler.RegexTextHandler;
import com.gekhub.kantur.grep.core.handler.TextHandler;
import com.gekhub.kantur.grep.core.handler.WordTextHandler;
import com.gekhub.kantur.grep.core.source.FileSourceProvider;
import com.gekhub.kantur.grep.core.source.SourceLoader;
import com.gekhub.kantur.grep.core.source.SourceProvider;
import com.gekhub.kantur.grep.core.source.URLSourceProvider;

import java.util.ArrayList;
import java.util.List;

public class LoadersCreator {
    public HandlerLoader handlerLoaderCreate() {
        List<TextHandler> textHandlers = new ArrayList<>();
        textHandlers.add(new WordTextHandler());
        textHandlers.add(new RegexTextHandler());
        return (new HandlerLoader(textHandlers));
    }

    public SourceLoader sourceLoaderCreate() {
        List<SourceProvider> sourceProviders = new ArrayList<>();
        sourceProviders.add(new FileSourceProvider());
        sourceProviders.add(new URLSourceProvider());
        return (new SourceLoader(sourceProviders));
    }
}