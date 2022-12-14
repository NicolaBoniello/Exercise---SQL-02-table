package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Students {
static final String DB_URL = "jdbc:mysql://localhost:3306/newdb";
static final String USER = "developer";
static final String PASSWORD = "Milanista1997";

public void createTable(){
    Connection conn = null;
    try{
        /**
         * create connectione to the database;
         */
        conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);

        /**
         * create a statement
         */
        Statement statement = conn.createStatement();

        /**
         * Create query
         */
        String createQuery = """
                CREATE TABLE IF NOT EXISTS students
                (student_id INT(10) NOT NULL AUTO_INCREMENT,
                last_name VARCHAR(30),
                first_name VARCHAR(30),
                CONSTRAINT students_pk PRIMARY KEY (student_id)
                );
                """;

       statement.executeUpdate(createQuery);
        System.out.println("La tabella è stata creata");


    }catch (SQLException e){
        System.out.println(e.getMessage());
    }
}

    public void insertStudents(String last_name, String first_name) throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);

        Statement statement = conn.createStatement();
        String createQuery = "INSERT INTO students (last_name, first_name) " + "VALUE ('"+last_name+"', '"+first_name+"')" ;

        statement.execute(createQuery);

        System.out.println("L'utente è stato creato");
    }
}