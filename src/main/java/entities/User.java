package entities;

import java.sql.Timestamp;

public class User {
    private int user_id;
    private String user_name;
    private String user_pass;
    private String user_email;


    public User()
    {

    }
    public User(int user_id)
    {
        this.user_id = user_id;
    }
    public User(String user_name, String user_pass) {
        this.user_name = user_name;
        this.user_pass = user_pass;
        this.user_email = null;
    }

    public User(String user_name, String user_pass, String user_email) {
        this.user_name = user_name;
        this.user_pass = user_pass;
        this.user_email = user_email;
    }

    public User(int user_id, String user_name, String user_pass, String user_email) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_pass = user_pass;
        this.user_email = user_email;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_pass='" + user_pass + '\'' +
                ", user_email='" + user_email + '\'' +
                '}';
    }
}
