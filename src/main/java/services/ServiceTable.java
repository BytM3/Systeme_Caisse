package services;

import entities.Menu;
import entities.Table;
import utils.MyDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceTable implements IService<Table>{

    public Connection con;
    public ServiceTable()
    {
        con = MyDB.getInstance().getConnection();
    }

    @Override
    public void add(Table table) throws SQLException {
        String req="INSERT INTO tables(table_id,table_name,table_desc,table_size,table_number) VALUES(?,?,?,?,?)";
        PreparedStatement pre = con.prepareStatement(req);
        pre.setInt(1,table.getTable_id());
        pre.setString(2,table.getTable_name());
        pre.setString(3,table.getTable_desc());
        pre.setInt(4,table.getTable_size());
        pre.setInt(5,table.getTable_number());
        pre.executeUpdate();
    }

    @Override
    public void update(Table table) throws SQLException {
        String req="UPDATE tables SET table_name=?,table_desc=?,table_size=?,table_number=? where table_id=?";
        PreparedStatement pre = con.prepareStatement(req);
        pre.setString(1,table.getTable_name());
        pre.setString(2,table.getTable_desc());
        pre.setInt(3,table.getTable_size());
        pre.setInt(4,table.getTable_number());
        pre.setInt(5,table.getTable_id());
        pre.executeUpdate();
    }

    @Override
    public void delete(Table table) throws SQLException {
        String req= "DELETE FROM tables WHERE table_id="+table.getTable_id()+";";
        Statement ste = con.createStatement();
        ste.executeUpdate(req);
    }

    @Override
    public List<Table> show() throws SQLException {
        List<Table> tables = new ArrayList<Table>();
        String req="SELECT * FROM  tables";
        PreparedStatement pre = con.prepareStatement(req);
        ResultSet res = pre.executeQuery();
        while(res.next())
        {
            Table t = new Table();
            t.setTable_id(res.getInt(1));
            t.setTable_name(res.getString(2));
            t.setTable_desc(res.getString(3));
            t.setTable_number(res.getInt(4));
            t.setTable_size(res.getInt(5));
            tables.add(t);
        }
        System.out.println(tables);
        return tables;
    }

}
