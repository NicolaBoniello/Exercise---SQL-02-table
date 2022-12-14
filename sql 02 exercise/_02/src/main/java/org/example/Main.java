package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Students students = new Students();
        students.createTable();
        students.insertStudents("De paola", "Mirella");
    }
}
