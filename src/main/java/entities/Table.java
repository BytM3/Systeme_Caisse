package entities;

public class Table {
    private int table_id,table_number,table_size;
    private String table_name,table_desc;

    //CONSTRUCTERS

    public Table()
    {

    }
    public Table(int table_number, String table_name, String table_desc) {
        this.table_number = table_number;
        this.table_name = table_name;
        this.table_desc = table_desc;
    }
    public Table(int table_number, int table_size, String table_name, String table_desc) {
        this.table_number = table_number;
        this.table_size = table_size;
        this.table_name = table_name;
        this.table_desc = table_desc;
    }

    public Table(int table_id, int table_number, int table_size, String table_name, String table_desc) {
        this.table_id = table_id;
        this.table_number = table_number;
        this.table_size = table_size;
        this.table_name = table_name;
        this.table_desc = table_desc;
    }

    @Override
    public String toString() {
        return "Table{" +
                "table_id=" + table_id +
                ", table_number=" + table_number +
                ", table_size=" + table_size +
                ", table_name='" + table_name + '\'' +
                ", table_desc='" + table_desc + '\'' +
                '}';
    }

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }

    public int getTable_number() {
        return table_number;
    }

    public void setTable_number(int table_number) {
        this.table_number = table_number;
    }

    public int getTable_size() {
        return table_size;
    }

    public void setTable_size(int table_size) {
        this.table_size = table_size;
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    public String getTable_desc() {
        return table_desc;
    }

    public void setTable_desc(String table_desc) {
        this.table_desc = table_desc;
    }
}
