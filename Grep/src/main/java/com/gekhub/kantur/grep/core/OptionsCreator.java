package com.gekhub.kantur.grep.core;

import org.apache.commons.cli.Options;

public class OptionsCreator {

    public Options optionsCreate(Options options) {
        options.addOption("w", "word", true, "Word to search");
        options.addOption("r", "regex", true, "Regular expression to search");
        options.addOption("f", "file", true, "File as source of the text");
        options.addOption("u", "url", true, "URL address as source of the text");
        options.addOption("h", "help", false, "Shows this help");
        return options;
    }
}