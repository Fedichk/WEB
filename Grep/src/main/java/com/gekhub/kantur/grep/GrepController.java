package com.gekhub.kantur.grep;

import com.gekhub.kantur.grep.core.Help;
import com.gekhub.kantur.grep.core.OptionsCreator;
import com.gekhub.kantur.grep.core.OptionsParser;
import com.gekhub.kantur.grep.core.source.SourceLoadingException;
import org.apache.commons.cli.*;

public class GrepController {
    public static void main(String[] args) {
        Options options = new OptionsCreator().getOptions();

        try {
            CommandLine commandLine = new DefaultParser().parse(options, args);
            if (commandLine.hasOption("h") || commandLine.hasOption("help")) {
                new Help().printHelp(options);
            } else {
                OptionsParser parser = new OptionsParser();
                String text = parser.sourceParse(commandLine).load();
                System.out.println(parser.argumentsParse(commandLine).handling(text));
            }
        } catch (UnrecognizedOptionException e) {
            System.out.println("Please, insert correct parameter, or use help");
        } catch (SourceLoadingException e) {
            System.out.println("We can`t load text from your source, please choose another one");
        } catch (ParseException e) {
            System.out.println("Something went wrong :(");
        }
    }
}