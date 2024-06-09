package entities;

public class Ticketitem {
    private int ticketitem_id,item_id,quantity;
    private String itemname;
    private float total;

    public Ticketitem()
    {

    }
    public Ticketitem(int item_id, int quantity, String itemname, float total) {
        this.item_id = item_id;
        this.quantity = quantity;
        this.itemname = itemname;
        this.total = total;
    }
    public Ticketitem(int ticketitem_id, int item_id, int quantity, String itemname, float total) {
        this.ticketitem_id = ticketitem_id;
        this.item_id = item_id;
        this.quantity = quantity;
        this.itemname = itemname;
        this.total = total;
    }

    public int getTicketitem_id() {
        return ticketitem_id;
    }

    public void setTicketitem_id(int ticketitem_id) {
        this.ticketitem_id = ticketitem_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
