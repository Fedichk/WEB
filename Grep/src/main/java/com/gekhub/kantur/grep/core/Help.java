package com.gekhub.kantur.grep.core;

import org.apache.commons.cli.*;

public class Help {
    public void printHelp (Options options){
        HelpFormatter hf = new HelpFormatter();
        hf.printHelp("java -jar grep.jar", options);
    }
}