package com.geekhub.hw10.task2;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PageCrawler {
    public static final int NUMBER_OF_THREADS = 10;

    private ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private String folder;

    public PageCrawler(String folder) throws MalformedURLException {
        this.folder = folder;
    }
    public void downloadPages(String pathToFile) throws IOException {
        TxtFile txtFile = new TxtFile();
        for (String url : txtFile.getPageLinks(pathToFile)) {
                executorService.execute(new PageTask(new URL(url), folder));
        }
    }

    public void stop() {
        executorService.shutdown();
    }
}
