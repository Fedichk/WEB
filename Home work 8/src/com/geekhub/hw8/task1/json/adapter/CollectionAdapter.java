package com.geekhub.hw8.task1.json.adapter;

import org.json.JSONException;

import java.util.Collection;

/**
 * Converts all objects that extends java.util.Collections to JSONArray.
 */
public class CollectionAdapter implements JsonDataAdapter<Collection> {

    @Override
    public Object toJson(Collection c) throws JSONException{
        return c;
    }
}