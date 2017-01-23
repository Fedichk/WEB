import com.geekhub.hw9.task1.objects.Cat;
import com.geekhub.hw9.task1.storage.DatabaseStorage;
import com.geekhub.hw9.task1.storage.Storage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseStorageTest {

    Connection createConn() throws Exception {
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:h2:~/test",
                "sa",
                "");
        return connection;
    }

    @Before
    public void createTable() throws Exception {
        Connection conn = createConn();
        String test = "CREATE TABLE cat" +
                "(ID INT AUTO_INCREMENT PRIMARY KEY NOT NULL," +
                "NAME VARCHAR NOT NULL," +
                "AGE INT NOT NULL)";

        String insert = "INSERT INTO cat VALUES(1, 'Murka', 5);" +
                "INSERT INTO cat VALUES(2, 'Barsik', 2);" +
                "INSERT INTO cat VALUES(3, 'Pushistik', 4);" +
                "INSERT INTO cat VALUES(4, 'Tom', 1);";

        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(test);
            stmt.executeUpdate(insert);
        }
        conn.close();
    }

    @After
    public void deleteTable() throws Exception {
        Connection conn = createConn();
        String delete = "DROP TABLE IF EXISTS cat;";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(delete);
        }
        conn.close();
    }

    @Test
    public void getExactlyWhatWeWantTest() throws Exception {
        Storage base = new DatabaseStorage(createConn());
        Assert.assertEquals(Cat.class, base.get(Cat.class, 1).getClass());
        Assert.assertEquals("Murka", base.get(Cat.class, 1).getName());
        Assert.assertEquals(5, base.get(Cat.class, 1).getAge());
    }

    @Test
    public void getWhatIsNotExistsTest() throws Exception {
        Storage base = new DatabaseStorage(createConn());
        Assert.assertNull(base.get(Cat.class, 100));
    }

    @Test
    public void listExactlyWhatWeWantTest() throws Exception {
        Storage base = new DatabaseStorage(createConn());
        Assert.assertEquals(4, base.list(Cat.class).size());
        Assert.assertEquals("Tom", base.list(Cat.class).get(3).getName());
    }

    @Test
    public void listIsEmptyFromEmptyTableTest() throws Exception {
        Storage base = new DatabaseStorage(createConn());
        base.delete(Cat.class);
        Assert.assertTrue(base.list(Cat.class).isEmpty());
    }

    @Test
    public void deleteAllRowsTableTest() throws Exception{
        Storage base = new DatabaseStorage(createConn());
        Assert.assertEquals(4, base.delete(Cat.class));
        Assert.assertEquals(0, base.delete(Cat.class));
    }

    @Test
    public void saveToBaseNewObjectTest() throws Exception{
        Storage base = new DatabaseStorage(createConn());
        Cat cat = new Cat();
        cat.setName("Pushok");
        cat.setAge(8);
        base.save(cat);
        Assert.assertEquals("Pushok", base.get(Cat.class, 5).getName());
    }

    @Test
    public void updateBaseWithNewNameOfExistingObjectTest() throws Exception{
        Storage base = new DatabaseStorage(createConn());
        Cat cat = new Cat();
        cat.setName("Puhlyachok");
        cat.setId(4);
        base.save(cat);
        Assert.assertEquals("Puhlyachok", base.get(Cat.class, 4).getName());
    }

    @Test
    public void deleteSimpleObjectFromBaseTest() throws Exception {
        Storage base = new DatabaseStorage(createConn());
        Cat cat = new Cat();
        cat.setName("Jorik");
        cat.setAge(7);
        base.save(cat);
        Assert.assertTrue(base.delete(cat));
    }



    }
