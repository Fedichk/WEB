package com.geekhub.hw10.task1;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/geo?autoReconnect=true&useSSL=false",
                "root",
                "12345");
//        create table country(
//                id			bigint not null primary key,
//        name		character varying(128) not null,
//                crt_date	DATETIME NOT NULL DEFAULT NOW());
//
//        create table region(
//                id			bigint not null primary key,
//        country_id	bigint not null REFERENCES country (id),
//                name		character varying(128) not null,
//                crt_date	DATETIME NOT NULL DEFAULT NOW());
//
//        create table city(
//                id		BIGINT UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE	create table country(
//        region_id	bigint not null REFERENCES region (id),
//                name		character varying(128) not null,
//                crt_date	DATETIME NOT NULL DEFAULT NOW());

// 4.1

//        SELECT c.name, COUNT(r.name) AS sum_of_regions
//        FROM country c
//        INNER JOIN region r
//        ON c.id = r.country_id
//        GROUP BY c.name
//        ORDER BY sum_of_regions DESC
//        LIMIT 5

// 4.2




    }
}

