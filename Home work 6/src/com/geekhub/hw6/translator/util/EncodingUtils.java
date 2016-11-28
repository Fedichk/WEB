package com.geekhub.hw6.translator.util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class EncodingUtils {

    private EncodingUtils() {
    }

    public static String encode(String text, String charset) throws UnsupportedEncodingException {

        JSONObject jsonObj = new JSONObject(text);
        if (charset.equals("text")) {
            JSONArray jsonArr = (JSONArray) jsonObj.get(charset);
            return jsonArr.getString(0);
        } else {
            return jsonObj.getString(charset);
        }
    }
}