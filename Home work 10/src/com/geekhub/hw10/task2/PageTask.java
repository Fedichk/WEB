package com.geekhub.hw10.task2;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PageTask implements Runnable {
    private URL url;
    private String folder;

    public PageTask(URL url, String folder) {
        this.url = url;
        this.folder = folder;
    }

    @Override
    public void run() {
       try {
            Files.write(Paths.get(folder + "/" + buildFileName(url)),
                    MessageDigest.getInstance("MD5").digest(ConnectionUtils.getData(url)));
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private String buildFileName(URL url) {
        return url.toString().replaceAll("[^a-zA-Z0-9-_\\.]", "_");
    }
}
