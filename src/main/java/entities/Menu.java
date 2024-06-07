package entities;

public class Menu {
    private int menu_id;
    private String menu_name;
    private String menu_desc;

    public Menu()
    {

    }
    public Menu(int menu_id) {
        this.menu_id = menu_id;
    }
    public Menu(int menu_id, String menu_name, String menu_desc) {
        this.menu_id = menu_id;
        this.menu_name = menu_name;
        this.menu_desc = menu_desc;
    }


    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getMenu_desc() {
        return menu_desc;
    }

    public void setMenu_desc(String menu_desc) {
        this.menu_desc = menu_desc;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menu_id=" + menu_id +
                ", menu_name='" + menu_name + '\'' +
                ", menu_desc='" + menu_desc + '\'' +
                '}';
    }
}
