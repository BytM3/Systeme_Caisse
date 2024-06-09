package entities;

import java.sql.Timestamp;

public class Ticket {
    private int ticket_id,ticketItem_id,table_id,active;
    private Timestamp created,killed;

    public Ticket()
    {

    }
    public Ticket(int ticketItem_id, int table_id, int active)
    {
        this.ticketItem_id = ticketItem_id;
        this.table_id = table_id;
        this.active = active;
    }
    public Ticket(int ticketItem_id, int table_id, int active, Timestamp created, Timestamp killed)
    {
        this.ticketItem_id = ticketItem_id;
        this.table_id = table_id;
        this.active = active;
        this.created = created;
        this.killed = killed;
    }
    public Ticket(int ticket_id, int ticketItem_id, int table_id, int active, Timestamp created, Timestamp killed) {
        this.ticket_id = ticket_id;
        this.ticketItem_id = ticketItem_id;
        this.table_id = table_id;
        this.active = active;
        this.created = created;
        this.killed = killed;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public int getTicketItem_id() {
        return ticketItem_id;
    }

    public void setTicketItem_id(int ticketItem_id) {
        this.ticketItem_id = ticketItem_id;
    }

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getKilled() {
        return killed;
    }

    public void setKilled(Timestamp killed) {
        this.killed = killed;
    }
}
