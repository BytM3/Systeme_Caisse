package controllers.Admin;

import controllers.Entities.Item.ItemShow;
import controllers.Entities.Users.UserShow;
import entities.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import services.ServiceUser;

import java.io.IOException;
import java.sql.SQLException;

public class DashboardAdminUsers {

    @FXML
    private Pane Delete_Screen_id;

    @FXML
    private Button add_id;

    @FXML
    private Button delete_id;

    @FXML
    private Button items_dash_id;

    @FXML
    private Button menu_dash_id;

    @FXML
    private Button show_id;

    @FXML
    private Button user_dash_id;

    //TABLE VARIABLES
    @FXML
    private TableView<User> table_id;
    @FXML
    private TableColumn<User, String> name_id;
    @FXML
    private TableColumn<User, String> pass_id;
    ServiceUser SU = new ServiceUser();

    @FXML
    void AddUser(ActionEvent event){
        try{
            //LOAD THE PAGE
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Entities/Users/User_Add.fxml"));
            Parent root= fxmlLoader.load();
            //CHANGE THE PAGE
            add_id.getScene().setRoot(root);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    @FXML
    void CancelDeletion(ActionEvent event) {
        Delete_Screen_id.setVisible(false);
    }

    @FXML
    void DoDeleteTheUser(ActionEvent event) throws SQLException {
        SU.delete(table_id.getSelectionModel().getSelectedItem());
        Delete_Screen_id.setVisible(false);
        Refresh();
    }

    @FXML
    void deleteUser(ActionEvent event) {
        if(table_id.getSelectionModel().getSelectedItem() != null) {
            Delete_Screen_id.setVisible(true);
        }
    }

    @FXML
    void goToItems(ActionEvent event){
        try{
            //LOAD THE PAGE
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Admin/Dashboard_Items.fxml"));
            Parent root= fxmlLoader.load();
            //CHANGE THE PAGE
            add_id.getScene().setRoot(root);
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
            add_id.getScene().setRoot(root);
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
            add_id.getScene().setRoot(root);
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void showUser(ActionEvent event) {
        if(table_id.getSelectionModel().getSelectedItem() != null) {
            try {
                //LOAD THE PAGE
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Entities/Users/User_Show.fxml"));
                Parent root = fxmlLoader.load();
                //Extract the Controller
                UserShow cont = fxmlLoader.getController();
                //SET THE DATA
                cont.SetData(table_id.getSelectionModel().getSelectedItem());
                //CHANGE THE PAGE
                add_id.getScene().setRoot(root);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void initialize()
    {
        Refresh();
    }
    private void Refresh()
    {
        try{
            ObservableList<User> list = FXCollections.observableList(SU.show());
            table_id.setItems(list);
            name_id.setCellValueFactory(new PropertyValueFactory<User,String>("user_name"));
            pass_id.setCellValueFactory(new PropertyValueFactory<User,String>("user_pass"));
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
