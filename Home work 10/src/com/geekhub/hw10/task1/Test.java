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
//                id		BIGINT UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
//        region_id	bigint not null REFERENCES region (id),
//                name		character varying(128) not null,
//                crt_date	DATETIME NOT NULL DEFAULT NOW());

// 4.1

//        SELECT c.name, COUNT(r.id) AS sum_of_regions
//        FROM country c
//        JOIN region r
//        ON c.id = r.country_id
//        GROUP BY c.id
//        ORDER BY sum_of_regions DESC, c.name
//        LIMIT 5

// 4.2

//        SELECT c.name, COUNT(ci.id) AS sum_of_citys
//        FROM country c
//        JOIN region r
//        ON c.id = r.country_id
//        JOIN city ci
//        ON r.id = ci.region_id
//        GROUP BY c.id
//        ORDER BY sum_of_citys DESC, c.name
//        LIMIT 5

// 4.3

//        SELECT c.name, COUNT(DISTINCT r.id) AS sum_of_regions, COUNT(ci.id) AS sum_of_citys
//        FROM country c
//        JOIN region r
//        ON c.id = r.country_id
//        JOIN city ci
//        ON r.id = ci.region_id
//        GROUP BY c.id
//        ORDER BY sum_of_citys DESC, sum_of_regions DESC, c.name
    }
}

