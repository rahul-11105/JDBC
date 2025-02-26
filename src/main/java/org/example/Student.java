package org.example;

import com.mysql.cj.Query;
import com.mysql.cj.jdbc.StatementImpl;

import java.sql.*;


public class Student {
    public void createDatabase() {
        //load driver
        //establish connection
        //statement creation
        //execute statement
        //close connection
        try{
            String url = "jdbc:mysql://localhost:3306/";
            String userName = "root";
            String password = "rahul@11105";
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection((url), userName, password);
            Statement st = conn.createStatement();
            String Query = "create database class";

            st.execute(Query);

            System.out.println("connected Successfully");
            System.out.println("database created Successfully");
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public void dropDB(String DBName) {
        //load driver
        //establish connection
        //statement creation
        //execute statement
        //close connection
        try{
            String url = "jdbc:mysql://localhost:3306/";
            String userName = "root";
            String password = "rahul@11105";
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection((url+DBName), userName, password);
            Statement st = conn.createStatement();
            String Query = "Drop database" + DBName;

            st.execute(Query);

            System.out.println("database deleted Successfully");
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }


    public void createTable() {
        try{
            String url = "jdbc:mysql://localhost:3306/class";
            String userName = "root";
            String password = "rahul@11105";
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection((url), userName, password);
            Statement st = conn.createStatement();
            String Query = "create table student(sid int(3), sname varchar(100), semail varchar(200))";
            st.execute(Query);
            System.out.println("Table created Successfully");
            conn.close();


        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void createData(int id,String name, String email) {
        try{
            String url = "jdbc:mysql://localhost:3306/class";
            String userName = "root";
            String password = "rahul@11105";
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection((url), userName, password);
            String Query = "insert into student(sid,sname,semail) values (?,?,?)";

            PreparedStatement pst = conn.prepareStatement(Query);
            pst.setInt(1,id);
            pst.setString(2,name);
            pst.setString(3,email);
            pst.execute();
            System.out.println("values inserted Successfully");
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void readData() {
        try{
            String url = "jdbc:mysql://localhost:3306/class";
            String userName = "root";
            String password = "rahul@11105";
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection((url), userName, password);
            String Query = "select * from student";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(Query);
            while (rs.next()) {
                System.out.print("ID = "+rs.getInt("sid")+" | ");
                System.out.print("NAME = "+rs.getString("sname")+" | ");
                System.out.print("EMAIL = "+rs.getString("semail")+" | ");
                System.out.println();
                System.out.println();
            }
            System.out.println("read Successfully");
            rs.close();
            conn.close();


        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updateData() {
        try{
            String url = "jdbc:mysql://localhost:3306/class";
            String userName = "root";
            String password = "rahul@11105";
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection((url), userName, password);
            String Query = "update student set sid = ? where sname = ?";

            PreparedStatement pst = conn.prepareStatement(Query);
            pst.setInt(1,2);
            pst.setString(2,"rahul");

            pst.execute();
            System.out.println("value updated Successfully");
            conn.close();


        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
