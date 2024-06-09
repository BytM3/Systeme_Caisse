package controllers.Entities.Table;

import controllers.Entities.Users.UserUpdate;
import entities.Table;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import services.ServiceTable;

import java.io.IOException;
import java.sql.SQLException;

public class TableShow {
    //
    Table currTable;
    @FXML
    private TextArea desc_id;

    @FXML
    private TextField nom_id;

    @FXML
    private TextField num_id;

    @FXML
    private TextField size_id;

    @FXML
    private Pane Delete_Screen_id;

    ServiceTable ST = new ServiceTable();
    public void SetData(Table table)
    {
        currTable = table;
        desc_id.setText(table.getTable_desc());
        nom_id.setText(table.getTable_name());
        size_id.setText(""+table.getTable_size());
        num_id.setText(""+table.getTable_number());
    }

    @FXML
    void DELETETABLE(ActionEvent event) {
        Delete_Screen_id.setVisible(true);
    }

    @FXML
    void UpdateTable(ActionEvent event) {
        try {
            //LOAD THE PAGE
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Entities/Table/Table_Update.fxml"));
            Parent root = fxmlLoader.load();
            //Extract the Controller
            TableUpdate cont = fxmlLoader.getController();
            //SET THE DATA
            cont.SetData(currTable);
            //CHANGE THE PAGE
            Delete_Screen_id.getScene().setRoot(root);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void CancelDeletion(ActionEvent event) {
        Delete_Screen_id.setVisible(false);
    }

    @FXML
    void DoDeleteTheItem(ActionEvent event) {
        try{
            ST.delete(currTable);
            GoBack();
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void CancelTheAdd(ActionEvent event) {
        GoBack();
    }
    @FXML
    private void initialize()
    {
        Delete_Screen_id.setVisible(false);
    }

    private void GoBack()
    {
        try{
            //LOAD THE PAGE
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Admin/Dashboard_Table.fxml"));
            Parent root= fxmlLoader.load();
            //CHANGE THE PAGE
            desc_id.getScene().setRoot(root);
        }catch(
                IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

}
