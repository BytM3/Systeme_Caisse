package services;

import entities.Item;
import utils.MyDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceItem implements IService<Item>{
    public Connection con;
    public ServiceItem()
    {
        con = MyDB.getInstance().getConnection();
    }

    @Override
    public void add(Item item) throws SQLException {
        String req= "INSERT INTO item(item_id,item_name,item_desc,item_price,type,menu_id) VALUES(?,?,?,?,?,?)";
        PreparedStatement pre = con.prepareStatement(req);
        pre.setInt(1,item.getItem_id());
        pre.setString(2,item.getItem_name());
        pre.setString(3,item.getItem_desc());
        pre.setFloat(4,item.getItem_price());
        pre.setInt(5,item.getType());
        pre.setInt(6,item.getMenu_id());
        pre.executeUpdate();
    }

    @Override
    public void update(Item item) throws SQLException {
        String req ="UPDATE item set item_name=?,item_desc=?,item_price=?,type=?,menu_id=? where item_id=?";
        PreparedStatement pre = con.prepareStatement(req);
        pre.setInt(6,item.getItem_id());
        pre.setString(1,item.getItem_name());
        pre.setString(2,item.getItem_desc());
        pre.setFloat(3,item.getItem_price());
        pre.setInt(4,item.getType());
        pre.setInt(5,item.getMenu_id());
        pre.executeUpdate();

    }

    @Override
    public void delete(Item item) throws SQLException {
        String req="DELETE FROM item WHERE item_id="+item.getItem_id()+";";
        Statement ste = con.createStatement();
        ste.executeUpdate(req);
    }

    @Override
    public List<Item> show() throws SQLException {
        List<Item> items = new ArrayList<>();
        String req ="SELECT * FROM item";
        PreparedStatement pre = con.prepareStatement(req);
        ResultSet res = pre.executeQuery();

        while(res.next())
        {
            Item i = new Item();
            i.setItem_id(res.getInt(1));
            i.setItem_name(res.getString(2));
            i.setItem_desc(res.getString(3));
            i.setItem_price(res.getFloat(4));
            i.setType(res.getInt(5));
            i.setMenu_id(res.getInt(6));
            items.add(i);
        }
        return items;
    }
}
