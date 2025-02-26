package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] arg) {
        Student st = new Student();
        //st.createDatabase();
        //st.dropDB("DB");
        //st.createTable();
        //st.createData(5,"peter","peterParker123@gmail.com");
        st.readData();
        //st.updateData();
    }
}