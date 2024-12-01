package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class databases extends Quizes {
    public void createdatabases(){
        try{
            String url = "jdbc:mysql://localhost:3306/";
            String user = "root";
            String password = "ranjan9570";
            Connection conn = DriverManager.getConnection(url,user,password);
            Statement stm = conn.createStatement();
            String query = "create database FRIENDS";
            stm.execute(query);
            System.out.println("Create databese successfully");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void createtable() {
        try{
            String url = "jdbc:mysql://localhost:3306/friends";
            String user = "root";
            String password = "ranjan9570";
            Connection conn = DriverManager.getConnection(url,user,password);
            Statement stm = conn.createStatement();
            String query = "create table friend(name varchar(20),Marks int(20))";
            stm.execute(query);
            System.out.println("Create table successfully");
            conn.close();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }


    }


    public void insertData() {
        try{


            Scanner n = new Scanner(System.in);
            System.out.println("Enter your name :");
            String name = n.nextLine();

            Quizes q = new Quizes();
            q.start();
            int score = q.results();




            String url = "jdbc:mysql://localhost:3306/";
            String db = "friends";
            String user = "root";
            String password = "ranjan9570";
            Connection conn = DriverManager.getConnection(url+db,user,password);
            String query = "INSERT into friends(name,Marks)VALUES(?,?)";

            PreparedStatement pstm = conn.prepareStatement(query);

            pstm.setString(1,name);

            pstm.setInt(2,score);
            pstm.execute();
            System.out.println("data enter successfully");
            conn.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
