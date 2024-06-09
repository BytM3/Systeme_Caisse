package services;

import entities.Ticketitem;
import utils.MyDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceTicketItem implements IService<Ticketitem>{
    public Connection con;
    public ServiceTicketItem()
    {
        con = MyDB.getInstance().getConnection();
    }

    @Override
    public void add(Ticketitem tickItem) throws SQLException {
        String req="INSERT INTO ticketitem(ticketitem_id,item_id,itemname,quantity,total) VALUES(?,?,?,?,?)";
        PreparedStatement pre = con.prepareStatement(req);
        pre.setInt(1,tickItem.getTicketitem_id());
        pre.setInt(2,tickItem.getItem_id());
        pre.setString(3,tickItem.getItemname());
        pre.setInt(4,tickItem.getQuantity());
        pre.setFloat(5,tickItem.getTotal());

        pre.executeUpdate();
    }

    @Override
    public void update(Ticketitem tickItem) throws SQLException {
        String req="UPDATE ticketitem SET item_id=?,itemname=?,quantity=?,total=? where ticketitem_id = ?";
        PreparedStatement pre = con.prepareStatement(req);
        pre.setInt(5,tickItem.getTicketitem_id());
        pre.setInt(1,tickItem.getItem_id());
        pre.setString(2,tickItem.getItemname());
        pre.setInt(3,tickItem.getQuantity());
        pre.setFloat(4,tickItem.getTotal());
        pre.executeUpdate();
    }

    @Override
    public void delete(Ticketitem tickItem) throws SQLException {
        String req ="DELETE FROM ticketitem where ticketitem_id="+tickItem.getTicketitem_id()+";";
        Statement ste = con.createStatement();
        ste.executeUpdate(req);
    }

    @Override
    public List<Ticketitem> show() throws SQLException {
        List<Ticketitem> ticketItems = new ArrayList<>();
        String req = "SELECT * from ticketitem";
        PreparedStatement pre = con.prepareStatement(req);
        ResultSet res = pre.executeQuery();
        while(res.next())
        {
            Ticketitem t = new Ticketitem();
            t.setTicketitem_id(res.getInt(1));
            t.setItem_id(res.getInt(2));
            t.setItemname(res.getString(3));
            t.setQuantity(res.getInt(4));
            t.setTotal(res.getFloat(5));
            ticketItems.add(t);
        }
        return ticketItems;
    }

}
