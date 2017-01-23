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
                "(ID INT PRIMARY KEY NOT NULL," +
                "NAME VARCHAR NOT NULL," +
                "AGE INT NOT NULL)";

        String insert = "INSERT INTO cat VALUES(1, 'Murka', 5);" +
                "INSERT INTO cat VALUES(2, 'Barsik', 2);";

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
    public void getExecetlyWhatWeWantTest() throws Exception {
        Storage base = new DatabaseStorage(createConn());
        Assert.assertEquals(Cat.class, base.get(Cat.class, 1).getClass());
        Assert.assertEquals("Murka", base.get(Cat.class, 1).getName());
        Assert.assertEquals(5, base.get(Cat.class, 1).getAge());
    }

    @Test
    public void getWhatIsNotExists() throws Exception {
        Storage base = new DatabaseStorage(createConn());
        Assert.assertNull(base.get(Cat.class, 100));
    }


}
