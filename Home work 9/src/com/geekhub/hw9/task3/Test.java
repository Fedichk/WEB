package com.geekhub.hw9.task3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) throws Exception {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:h2:~/test",
                "sa",
                "");

        String employ = "CREATE TABLE EMPLOY" +
                "(ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL," +
                "NAME VARCHAR NOT NULL)";

        String salary = "CREATE TABLE SALARY" +
                "(ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL," +
                "DATE DATE NOT NULL," +
                "VALUE DOUBLE NOT NULL," +
                "EMP_ID INTEGER NOT NULL," +
                "CONSTRAINT FOREIGN KEY (EMP_ID) REFERENCES EMPLOY (ID))";

//        try(Statement stmt = conn.createStatement()) {
//            stmt.executeUpdate(salary);
//        }
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery( "SELECT EMP_ID,  E.NAME, SUM (VALUE)" +
                     "FROM SALARY AS S " +
                     "INNER JOIN EMPLOY AS E " +
                     "ON S.EMP_ID = E.ID " +
                     "GROUP BY EMP_ID;")
        ){while ( rs.next() ) {
            System.out.println("Employee №" + rs.getInt(1) + " with name: " + rs.getString(2) + " ,got salary in amount: " + rs.getDouble(3));
        }
        }
    }
}
