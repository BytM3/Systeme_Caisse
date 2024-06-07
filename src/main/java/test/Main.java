package test;
import entities.*;
import services.*;
import utils.MyDB;

import java.sql.SQLException;

public class Main {

    public static void main (String Args[])
    {
        //Prepare Services
        ServiceUser serviceUser = new ServiceUser();
        //Connect to dataBase
        MyDB con = MyDB.getInstance();
        //Users to Add
//        User u1 = new User("Jawher","123","jawher.smida@gmail.com");
        //Test the Add Function
//        try{
//            serviceUser.add(u1);
//        }catch(SQLException e)
//        {
//            System.out.println(e.getMessage());
//        }
        //User to Modify
//        User u1 = new User(1,"Jawher","123","jawher.smida@gmail.com");
//        try{
//            serviceUser.update(u1);
//        }catch(SQLException e)
//        {
//            System.out.println(e.getMessage());
//        }
        //User To Read
//        try {
//            System.out.println(serviceUser.show());
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        //User To Delete
//        try{
//            User u1 = new User(1);
//            serviceUser.delete(u1);
//        }catch(SQLException e)
//        {
//            System.out.println(e.getMessage());
//        }
    }
}
