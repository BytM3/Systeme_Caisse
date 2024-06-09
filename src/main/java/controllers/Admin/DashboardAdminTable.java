package controllers.Admin;

import controllers.Entities.Table.TableAdd;
import controllers.Entities.Table.TableShow;
import controllers.Entities.Users.UserShow;
import entities.Table;
import entities.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import services.ServiceTable;

import java.io.IOException;
import java.sql.SQLException;

public class DashboardAdminTable {

    @FXML
    private Pane Delete_Screen_id;

    @FXML
    private TableColumn<Table, String> desc_id;

    @FXML
    private TableColumn<Table, String> name_id;

    @FXML
    private TableColumn<Table, Integer> num_id;

    @FXML
    private TableColumn<Table, Integer> size_id;

    @FXML
    private TableView<Table> table_id;

    ServiceTable ST = new ServiceTable();
    @FXML
    void AddTable(ActionEvent event) {
            try {
                //LOAD THE PAGE
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Entities/Table/Table_Add.fxml"));
                Parent root = fxmlLoader.load();
                //Extract the Controller
                TableAdd cont = fxmlLoader.getController();
                //CHANGE THE PAGE
                table_id.getScene().setRoot(root);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
    }

    @FXML
    void CancelDeletion(ActionEvent event) {
        Delete_Screen_id.setVisible(false);
    }

    @FXML
    void DeleteTable(ActionEvent event) {
        if(table_id.getSelectionModel().getSelectedItem() != null)
        {
            Delete_Screen_id.setVisible(true);
        }
    }

    @FXML
    void DoDeleteTheUser(ActionEvent event) {
        try{
            ST.delete(table_id.getSelectionModel().getSelectedItem());
            Delete_Screen_id.setVisible(false);
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void ShowTable(ActionEvent event) {
        if(table_id.getSelectionModel().getSelectedItem() != null) {
            try {
                //LOAD THE PAGE
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Entities/Table/Table_Show.fxml"));
                Parent root = fxmlLoader.load();
                //Extract the Controller
                TableShow cont = fxmlLoader.getController();
                //SET THE DATA
                cont.SetData(table_id.getSelectionModel().getSelectedItem());
                //CHANGE THE PAGE
                table_id.getScene().setRoot(root);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
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
    void goToItems(ActionEvent event){
        try{
            //LOAD THE PAGE
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Admin/Dashboard_Items.fxml"));
            Parent root= fxmlLoader.load();
            //CHANGE THE PAGE
            table_id.getScene().setRoot(root);
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void goToMenusAdmin(ActionEvent event) {
        try {
            //LOAD THE PAGE
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Admin/Dashboard_Menus.fxml"));
            Parent root= fxmlLoader.load();
            //CHANGE THE PAGE
            table_id.getScene().setRoot(root);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void goToUsersAdmin(ActionEvent event){
        try{
            //LOAD THE PAGE
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Admin/Dashboard_Users.fxml"));
            Parent root= fxmlLoader.load();
            //CHANGE THE PAGE
            table_id.getScene().setRoot(root);
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    private void initialize()
    {
        Refresh();
    }
    private void Refresh()
    {
        try{
            ObservableList<Table> list = FXCollections.observableList(ST.show());
            table_id.setItems(list);
            name_id.setCellValueFactory(new PropertyValueFactory<Table,String>("table_name"));
            desc_id.setCellValueFactory(new PropertyValueFactory<Table,String>("table_desc"));
            num_id.setCellValueFactory(new PropertyValueFactory<Table,Integer>("table_number"));
            size_id.setCellValueFactory(new PropertyValueFactory<Table,Integer>("table_size"));

        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

}
