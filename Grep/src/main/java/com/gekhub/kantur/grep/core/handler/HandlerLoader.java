package com.gekhub.kantur.grep.core.handler;

import com.gekhub.kantur.grep.core.source.SourceLoadingException;
import org.apache.commons.cli.CommandLine;

import java.util.ArrayList;
import java.util.List;

public class HandlerLoader {

    private List<TextHandler> textHandlers = new ArrayList<>();

    public HandlerLoader(List<TextHandler> textHandlers) {
        this.textHandlers = textHandlers;
    }

    public String handleText(CommandLine commandLine) throws SourceLoadingException {
        for (TextHandler handler : textHandlers) {
            if (handler.isAllowed(commandLine))
                return handler.handling(commandLine);
        }
        return null;
    }
}