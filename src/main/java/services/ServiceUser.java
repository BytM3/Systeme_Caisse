package services;

import entities.User;
import utils.MyDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceUser implements IService<User>{
    public Connection con;
    public ServiceUser()
    {
        con = MyDB.getInstance().getConnection();
    }

    @Override
    public void add(User user) throws SQLException {
        String req="INSERT INTO user(user_id,user_name,user_pass,user_email) VALUES(?,?,?,?)";
        PreparedStatement pre = con.prepareStatement(req);
        pre.setInt(1,user.getUser_id());
        pre.setString(2,user.getUser_name());
        pre.setString(3,user.getUser_pass());
        pre.setString(4,user.getUser_email());
        pre.executeUpdate();
    }

    @Override
    public void update(User user) throws SQLException {
        String req="UPDATE user SET user_name = ? , user_pass = ? , user_email = ? where user_id = ?";
        PreparedStatement pre = con.prepareStatement(req);
        pre.setString(1,user.getUser_name());
        pre.setString(2,user.getUser_pass());
        pre.setString(3,user.getUser_email());
        pre.setInt(4,user.getUser_id());
        pre.executeUpdate();
    }

    @Override
    public void delete(User user) throws SQLException {
        String req ="DELETE FROM user where user_id="+user.getUser_id()+";";
        Statement ste = con.createStatement();
        ste.executeUpdate(req);
    }

    @Override
    public List<User> show() throws SQLException {
        List<User> users = new ArrayList<>();
        String req = "SELECT * from user";
        PreparedStatement pre = con.prepareStatement(req);
        ResultSet res = pre.executeQuery();
        while(res.next())
        {
            User u = new User();
            u.setUser_id(res.getInt(1));
            u.setUser_name(res.getString(2));
            u.setUser_pass(res.getString(3));
            u.setUser_email(res.getString(4));
            users.add(u);
        }
        return users;
    }
    public User findUser(String username)
    {
        User temp = new User();
        try{
            List<User> users = show();
            temp = users.stream().filter(e->e.getUser_name().toLowerCase().equals(username.toLowerCase())).findFirst().get();
            return temp;
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
