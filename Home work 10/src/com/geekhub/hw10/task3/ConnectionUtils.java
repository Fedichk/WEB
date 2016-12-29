package com.geekhub.hw10.task3;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * Utils class that contains useful method to interact with URLConnection
 */
public class ConnectionUtils {

    /**
     * Downloads content for specified URL and returns it as a byte array.
     * Should be used for small files only. Don't use it to download big files it's dangerous.
     *
     * @param url
     * @return
     * @throws java.io.IOException
     */
    public static byte[] getData(URL url) throws IOException {
        byte[] buffer = new byte[1024];
        try (BufferedInputStream in = new BufferedInputStream(url.openStream());
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            int data;
            while ((data = in.read(buffer)) > 0) {
                out.write(buffer, 0, data);
            }
            return out.toByteArray();
        }
    }
}