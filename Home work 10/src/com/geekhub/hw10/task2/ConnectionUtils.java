package com.geekhub.hw10.task2;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

public class ConnectionUtils {
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
