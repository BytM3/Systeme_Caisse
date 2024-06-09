package controllers.Entities.Table;

import entities.Table;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import services.ServiceTable;

import java.io.IOException;
import java.sql.SQLException;

public class TableAdd {

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
    void AddTable(ActionEvent event) {
        try{
            Table table = new Table();
            table.setTable_name(nom_id.getText());
            table.setTable_desc(desc_id.getText());
            table.setTable_number(Integer.parseInt(num_id.getText()));
            table.setTable_size(Integer.parseInt(size_id.getText()));
            ST.add(table);
            GoBack();
        }catch(SQLException e)
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

    }
    private void GoBack()
    {
        try {
            //LOAD THE PAGE
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Admin/Dashboard_Table.fxml"));
            Parent root= fxmlLoader.load();
            //CHANGE THE PAGE
            nom_id.getScene().setRoot(root);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
