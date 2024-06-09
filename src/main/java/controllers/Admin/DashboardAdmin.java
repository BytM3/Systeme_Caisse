package controllers.Admin;

import controllers.Entities.Item.ItemShow;
import entities.Item;
import entities.Menu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import services.ServiceItem;
import services.ServiceMenu;

import java.io.IOException;
import java.sql.SQLException;

import javafx.beans.property.SimpleStringProperty;

public class DashboardAdmin {

    //DASHBOARD SWITCHING BUTTONS

    @FXML
    private Button user_dash_id;
    @FXML
    private Button menu_dash_id;
    @FXML
    private Button items_dash_id;

    //ACTION BUTTONS
    @FXML
    private Button add_id;
    @FXML
    private Button delete_id;
    @FXML
    private Button show_id;

    //TABLE VARIABLES
    @FXML
    private TableView<Item> table_id;
    @FXML
    private TableColumn<Item, String> name_id;
    @FXML
    private TableColumn<Item,String> desc_id;
    @FXML
    private TableColumn<Item, Float> price_id;
    @FXML
    private TableColumn<Item, Integer> type_id;
    @FXML
    private TableColumn<Item, String> menu_id;

    //INITIALIZE
    ServiceItem SI = new ServiceItem();
    ServiceMenu SM = new ServiceMenu();

    @FXML
    public void initialize() throws SQLException
    {
        Refresh();
        Delete_Screen_id.setVisible(false);
    }

    private void Refresh()
    {
        try
        {
            //ITEMS LIST
            ObservableList<Item> observableList = FXCollections.observableList(SI.show());
            //GET UserNAMES
            ObservableList<Menu> MenuList = FXCollections.observableList(SM.show());
            //ITEMS TABLE
            table_id.setItems(observableList);
            name_id.setCellValueFactory(new PropertyValueFactory<Item,String>("item_name"));
            desc_id.setCellValueFactory(new PropertyValueFactory<Item,String>("item_desc"));
            price_id.setCellValueFactory(new PropertyValueFactory<Item,Float>("item_price"));
            type_id.setCellValueFactory(new PropertyValueFactory<Item,Integer>("type"));
            menu_id.setCellValueFactory(e -> {
                int menuID = e.getValue().getMenu_id();
                Menu menu = null;
                for (Menu men : MenuList) {
                    if (men.getMenu_id() == menuID) {
                        menu = men;
                    }
                }
                return new SimpleStringProperty(menu != null ? menu.getMenu_name() : "Unknown");
            });
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }

    }
    @FXML
    void AddItem(ActionEvent event) throws Exception{
        //LOAD THE PAGE
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Entities/Item/Item_Add.fxml"));
        Parent root= fxmlLoader.load();
        //CHANGE THE PAGE
        add_id.getScene().setRoot(root);
    }

    @FXML
    private Pane Delete_Screen_id;
    @FXML
    void deleteItem(ActionEvent event) {
        if(table_id.getSelectionModel().getSelectedItem() != null) {
            Delete_Screen_id.setVisible(true);
        }
    }
    @FXML
    void CancelDeletion(ActionEvent event) {
        Delete_Screen_id.setVisible(false);
    }

    @FXML
    void DoDeleteTheItem(ActionEvent event) throws SQLException{
        SI.delete(table_id.getSelectionModel().getSelectedItem());
        Delete_Screen_id.setVisible(false);
        Refresh();
    }

    @FXML
    void goToItems(ActionEvent event) {
        Refresh();
    }

    @FXML
    void goToMenusAdmin(ActionEvent event) {
        try {
            //LOAD THE PAGE
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Admin/Dashboard_Menus.fxml"));
            Parent root= fxmlLoader.load();
            //CHANGE THE PAGE
            add_id.getScene().setRoot(root);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void goToUsersAdmin(ActionEvent event) {
        try{
            //LOAD THE PAGE
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Admin/Dashboard_Users.fxml"));
            Parent root= fxmlLoader.load();
            //CHANGE THE PAGE
            add_id.getScene().setRoot(root);
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    void goToTable(ActionEvent event) {
        try{
            //LOAD THE PAGE
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Admin/Dashboard_Table.fxml"));
            Parent root= fxmlLoader.load();
            //CHANGE THE PAGE
            table_id.getScene().setRoot(root);
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void showItem(ActionEvent event) throws IOException {
        if(table_id.getSelectionModel().getSelectedItem() != null) {
            //LOAD THE PAGE
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Entities/Item/Item_Show.fxml"));
            Parent root = fxmlLoader.load();
            //Extract the Controller
            ItemShow cont = fxmlLoader.getController();
            //SET THE DATA
            cont.SetData(table_id.getSelectionModel().getSelectedItem());
            //CHANGE THE PAGE
            add_id.getScene().setRoot(root);
        }
    }

}
