package com.geekhub.hw9.task1.storage;

import com.geekhub.hw9.task1.objects.Entity;
import com.geekhub.hw9.task1.objects.Ignore;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Implementation of {@link Storage} that uses database as a storage for objects.
 * It uses simple object type names to define target table to save the object.
 * It uses reflection to access objects fields and retrieve data to map to database tables.
 * As an identifier it uses field id of {@link Entity} class.
 * Could be created only with {@link Connection} specified.
 */
public class DatabaseStorage implements Storage {

    private Connection connection;

    public DatabaseStorage(Connection connection) {
        this.connection = connection;
    }

    @Override
    public <T extends Entity> T get(Class<T> clazz, Integer id) throws StorageException {
        //this method is fully implemented, no need to do anything, it's just an example
        String sql = "SELECT * FROM " + clazz.getSimpleName().toLowerCase() + " WHERE id = " + id;
        try (Statement statement = connection.createStatement()) {
            List<T> result = extractResult(clazz, statement.executeQuery(sql));
            return result.isEmpty() ? null : result.get(0);
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public <T extends Entity> List<T> list(Class<T> clazz) throws StorageException {
        String sql = "SELECT * FROM " + clazz.getSimpleName().toLowerCase();
        try (Statement statement = connection.createStatement()) {
            return extractResult(clazz, statement.executeQuery(sql));
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public <T extends Entity> boolean delete(T entity) throws StorageException {
        String sql = "DELETE FROM " + entity.getClass().getSimpleName().toLowerCase() + " WHERE id = " + entity.getId();
        try (Statement statement = connection.createStatement()) {
            return (statement.executeUpdate(sql) == 1);
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public <T extends Entity> void save(T entity) throws StorageException {
        //TODO: Implement me
    }

    //converts object to map, could be helpful in save method
    private <T extends Entity> Map<String, Object> prepareEntity(T entity) {
        //TODO: Implement me
        return null;
    }

    //creates list of new instances of clazz by using data from resultset
    private <T extends Entity> List<T> extractResult(Class<T> clazz, ResultSet resultSet) throws Exception {
        List<T> result = new ArrayList<>();
        while (resultSet.next()) {
            T object = (T) clazz.newInstance();
            Field[] fields = clazz.getDeclaredFields();
            object.setId(resultSet.getInt(1));
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                if (!fields[i].isAnnotationPresent(Ignore.class)) {
                    fields[i].set(object, resultSet.getObject(i+2));
                }
            }
            result.add(object);
        }
        return result;
    }
}