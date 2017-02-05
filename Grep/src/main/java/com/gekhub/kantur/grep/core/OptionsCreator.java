package com.gekhub.kantur.grep.core;

import org.apache.commons.cli.Options;

public class OptionsCreator {

    private Options options = new Options();

    public OptionsCreator() {
        this.options.addOption("w", "word", true, "Word to search");
        this.options.addOption("r", "regex", true, "Regular expression to search");
        this.options.addOption("f", "file", true, "File as source of the text");
        this.options.addOption("u", "url", true, "URL address as source of the text");
        this.options.addOption("h", "help", false, "Shows this help");
    }

    public Options getOptions() {
        return options;
    }
}