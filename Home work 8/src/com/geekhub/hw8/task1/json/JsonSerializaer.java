package com.geekhub.hw8.task1.json;

import com.geekhub.hw8.task1.json.adapter.JsonDataAdapter;
import com.geekhub.hw8.task1.json.adapter.UseDataAdapter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * JsonSerializer converts Java objects to JSON representation.
 */
public class JsonSerializaer {

    /**
     * simpleTypes contains java classes for which we should not make any deeper serialization and we should return object as is
     * and use toString() method to get it serialized representation
     */
    private static Set<Class> simpleTypes = new HashSet<Class>(Arrays.asList(
            JSONObject.class,
            JSONArray.class,
            String.class,
            Integer.class,
            Short.class,
            Long.class,
            Byte.class,
            Double.class,
            Float.class,
            Character.class,
            Boolean.class,
            int.class,
            short.class,
            long.class,
            byte.class,
            double.class,
            float.class,
            char.class,
            boolean.class
    ));

    /**
     * Main method to convert Java object to JSON. If type of the object is part of the simpleTypes object itself will be returned.
     * If object is null String value "null" will be returned.
     *
     * @param o object to serialize.
     * @return JSON representation of the object.
     */
    public static Object serialize(Object o) {
        if (null == o) {
            return "null";
        }
        if (simpleTypes.contains(o.getClass())) {
            return o;
        } else {
            try {
                return toJsonObject(o);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /**
     * Converts Java object to JSON. Uses reflection to access object fields.
     * Uses JsonDataAdapter to serialize complex values. Ignores @Ignore annotated fields.
     *
     * @param o object to serialize to JSON
     * @return JSON object.
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private static JSONObject toJsonObject(Object o) throws Exception {
        JSONObject jsonObj = new JSONObject();
        Class objClass = o.getClass();
        Field[] objFields = objClass.getDeclaredFields();
        for (Field field : objFields) {
            field.setAccessible(true);
            if (!field.isAnnotationPresent(Ignore.class)) {
                if (field.isAnnotationPresent(UseDataAdapter.class)) {
                    UseDataAdapter useDataAdapter = field.getAnnotation(UseDataAdapter.class);
                    JsonDataAdapter adapter = useDataAdapter.value().newInstance();
                    jsonObj.put(field.getName(), adapter.toJson(field.get(o)));
                } else {
                    jsonObj.put(field.getName(), serialize(field.get(o)));
                }
            }
        }
        return jsonObj;
    }
}