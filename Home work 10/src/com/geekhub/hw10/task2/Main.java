package com.geekhub.hw10.task2;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static final String FILE_TO_READ = "C://1/Links.txt";
    public static final String FOLDER_TO_DOWNLOAD = "C://Test";

    public static void main(String[] args) throws IOException {
        PageCrawler pageCrawler = new PageCrawler(FOLDER_TO_DOWNLOAD);
        pageCrawler.downloadPages(FILE_TO_READ);
        pageCrawler.stop();
    }
}
