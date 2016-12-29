package com.geekhub.hw10.task3;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Represents worker that downloads image from URL to specified folder.<br/>
 * Name of the image will be constructed based on URL. Names for the same URL will be the same.
 */
public class ImageTask implements Runnable {

    private URL url;
    private String folder;

    public ImageTask(URL url, String folder) {
        this.url = url;
        this.folder = folder;
    }

    /**
     * Inherited method that do main job - downloads the image and stores it at specified location
     */
    @Override
    public void run() {
//        try(FileOutputStream out = new FileOutputStream(folder + "/" + buildFileName(url))){
//            out.write(ConnectionUtils.getData(url), 0, ConnectionUtils.getData(url).length);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            Files.write(Paths.get(folder + "/" + buildFileName(url)), ConnectionUtils.getData(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //converts URL to unique file name
    private String buildFileName(URL url) {
        return url.toString().replaceAll("[^a-zA-Z0-9-_\\.]", "_");
    }
}
