package services;

import entities.Ticket;
import entities.User;
import utils.MyDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceTicket implements IService<Ticket>{
    public Connection con;
    public ServiceTicket()
    {
        con = MyDB.getInstance().getConnection();
    }

    @Override
    public void add(Ticket ticket) throws SQLException {
        String req="INSERT INTO ticket(ticket_id,ticketItem_id,table_id,active,created,killed) VALUES(?,?,?,?,?,?)";
        PreparedStatement pre = con.prepareStatement(req);
        pre.setInt(1,ticket.getTicket_id());
        pre.setInt(2,ticket.getTicketItem_id());
        pre.setInt(3,ticket.getTable_id());
        pre.setInt(4,ticket.getActive());
        pre.setTimestamp(5,ticket.getCreated());
        pre.setTimestamp(6,ticket.getKilled());

        pre.executeUpdate();
    }

    @Override
    public void update(Ticket ticket) throws SQLException {
        String req="UPDATE ticket SET ticketItem_id =?,table_id=?,active=?,created=?,killed=? where ticket_id = ?";
        PreparedStatement pre = con.prepareStatement(req);
        pre.setInt(1,ticket.getTicketItem_id());
        pre.setInt(2,ticket.getTable_id());
        pre.setInt(3,ticket.getActive());
        pre.setTimestamp(4,ticket.getCreated());
        pre.setTimestamp(5,ticket.getKilled());
        pre.setInt(6,ticket.getTable_id());
        pre.executeUpdate();
    }

    @Override
    public void delete(Ticket ticket) throws SQLException {
        String req ="DELETE FROM ticket where ticket_id="+ticket.getTicket_id()+";";
        Statement ste = con.createStatement();
        ste.executeUpdate(req);
    }

    @Override
    public List<Ticket> show() throws SQLException {
        List<Ticket> tickets = new ArrayList<>();
        String req = "SELECT * from ticket";
        PreparedStatement pre = con.prepareStatement(req);
        ResultSet res = pre.executeQuery();
        while(res.next())
        {
            Ticket t = new Ticket();
            t.setTicket_id(res.getInt(1));
            t.setTicketItem_id(res.getInt(2));
            t.setTable_id(res.getInt(3));
            t.setCreated(res.getTimestamp(4));
            t.setKilled(res.getTimestamp(5));
            t.setActive(res.getInt(6));
            tickets.add(t);
        }
        return tickets;
    }

}
