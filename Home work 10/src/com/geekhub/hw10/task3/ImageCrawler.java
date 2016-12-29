package com.geekhub.hw10.task3;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ImageCrawler downloads all images to specified folder from specified resource.
 * It uses multi threading to make process faster. To start download images you should call downloadImages(String urlToPage) method with URL.
 * To shutdown the service you should call stop() method
 */
public class ImageCrawler {

    //number of threads to download images simultaneously
    public static final int NUMBER_OF_THREADS = 10;

    private ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private String folder;

    public ImageCrawler(String folder) throws MalformedURLException {
        this.folder = folder;
    }

    /**
     * Call this method to start download images from specified URL.
     *
     * @param urlToPage
     * @throws java.io.IOException
     */
    public void downloadImages(String urlToPage) throws IOException {
        Page page = new Page(new URL(urlToPage));
        for (URL url : page.getImageLinks()) {
            if (isImageURL(url)) {
                executorService.execute(new ImageTask(url, folder));
            }
        }
        // You must use executorService to submit task for download
    }

    /**
     * Call this method before shutdown an application
     */
    public void stop() {
        executorService.shutdown();
    }

    //detects is current url is an image. Checking for popular extensions should be enough
    private boolean isImageURL(URL url) {
        return url.toString().matches("([^\\s]+(\\.(?i)(jpg|png))$)");
    }
}