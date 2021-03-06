package com.geekhub.hw9.task1;

import com.geekhub.hw9.task1.objects.Cat;
import com.geekhub.hw9.task1.storage.DatabaseStorage;
import com.geekhub.hw9.task1.storage.Storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class Test2 {
    public static void main(String[] args) throws Exception {
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/geekhub?autoReconnect=true&useSSL=false",
                "root",
                "12345");
//       String book = "CREATE TABLE `books` (\n" +
//                "  `id` int(11) NOT NULL,\n" +
//                "  `name` varchar(50) NOT NULL,\n" +
//                "  `author` varchar(50) NOT NULL,\n" +
//                "  PRIMARY KEY (`id`)\n" +
//                ") ENGINE=InnoDB DEFAULT CHARSET=latin1";
//        try(Statement stmt = conn.createStatement()) {
//            stmt.executeUpdate(book);
//        }

        Storage storage = new DatabaseStorage(conn);
        List<Cat> cats = storage.list(Cat.class);
        for (Cat cat : cats) {
            System.out.println(cat.getId() + " " + cat.getName() + " " + cat.getAge());
        }


            storage.delete(cats.get(5));

        List<Cat> catss = storage.list(Cat.class);
        for (Cat cat : catss) {
            System.out.println(cat.getId() + " " + cat.getName() + " " + cat.getAge());
        }


        conn.close();
    }
}
