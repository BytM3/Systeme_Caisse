package services;

import entities.Menu;
import utils.MyDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceMenu implements IService<Menu>{
    public Connection con;
    public ServiceMenu()
    {
        con = MyDB.getInstance().getConnection();
    }
    @Override
    public void add(Menu menu) throws SQLException {
        String req="INSERT INTO user(menu_id,menu_name,menu_desc) VALUES(?,?,?)";
        PreparedStatement pre = con.prepareStatement(req);
        pre.setInt(1,menu.getMenu_id());
        pre.setString(2,menu.getMenu_name());
        pre.setString(3,menu.getMenu_desc());
        pre.executeUpdate();
    }

    @Override
    public void update(Menu menu) throws SQLException {
        String req="UPDATE menu SET menu_name=?,menu_desc=? where menu_id=?";
        PreparedStatement pre = con.prepareStatement(req);
        pre.setString(1,menu.getMenu_name());
        pre.setString(2,menu.getMenu_desc());
        pre.setInt(3,menu.getMenu_id());
        pre.executeUpdate();
    }

    @Override
    public void delete(Menu menu) throws SQLException {
        String req= "DELETE FROM menu WHERE menu_id="+menu.getMenu_id()+";";
        Statement ste = con.createStatement();
        ste.executeUpdate(req);
    }

    @Override
    public List<Menu> show() throws SQLException {
        List<Menu> menus = new ArrayList<Menu>();
        String req="SELECT * FROM  menu";
        PreparedStatement pre = con.prepareStatement(req);
        ResultSet res = pre.executeQuery();
        while(res.next())
        {
            Menu m = new Menu();
            m.setMenu_id(res.getInt(1));
            m.setMenu_name(res.getString(2));
            m.setMenu_desc(res.getString(3));
            menus.add(m);
        }
        return menus;
    }
}
