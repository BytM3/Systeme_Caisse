package controllers.Entities.Table;

import controllers.Entities.Item.ItemShow;
import entities.Table;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import services.ServiceTable;

import java.io.IOException;
import java.util.Currency;

public class TableUpdate {
    Table currTable;
    @FXML
    private TextArea desc_id;

    @FXML
    private TextField nom_id;

    @FXML
    private TextField num_id;

    @FXML
    private TextField size_id;

    ServiceTable ST = new ServiceTable();
    @FXML
    void CancelTheAdd(ActionEvent event) {
        try{
            GoBackScript();
        }catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void UpdateTable(ActionEvent event) {
        try{
            Table t = currTable;
            t.setTable_name(nom_id.getText());
            t.setTable_desc(desc_id.getText());
            t.setTable_number(Integer.parseInt(num_id.getText()));
            t.setTable_size(Integer.parseInt(size_id.getText()));
            ST.update(t);
            currTable = t;
            GoBackScript();
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    private void GoBackScript() throws IOException
    {
        //LOAD THE PAGE
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Entities/Table/Table_Show.fxml"));
        Parent root = fxmlLoader.load();
        //Extract the Controller
        TableShow cont = fxmlLoader.getController();
        //SET THE DATA
        cont.SetData(currTable);
        //CHANGE THE PAGE
        num_id.getScene().setRoot(root);
    }
    public void SetData(Table table)
    {
        currTable = table;
        desc_id.setText(table.getTable_desc());
        nom_id.setText(table.getTable_name());
        size_id.setText(""+table.getTable_size());
        num_id.setText(""+table.getTable_number());
    }
}
