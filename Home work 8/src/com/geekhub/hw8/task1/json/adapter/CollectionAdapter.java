package com.geekhub.hw8.task1.json.adapter;

import com.geekhub.hw8.task1.json.JsonSerializaer;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.Collection;

/**
 * Converts all objects that extends java.util.Collections to JSONArray.
 */
public class CollectionAdapter implements JsonDataAdapter<Collection> {

    @Override
    public Object toJson(Collection c) throws JSONException {
        JSONArray collection = new JSONArray();
        for (Object o : c) {
            collection.put(JsonSerializaer.serialize(o));
        }
        return collection;
    }
}