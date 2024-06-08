package controllers.Entities.Users;

import entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import services.ServiceUser;

import java.io.IOException;
import java.sql.SQLException;

public class UserAdd {

    @FXML
    private Button add_butt;

    @FXML
    private Button cancel_butt;

    @FXML
    private TextField nom_id;

    @FXML
    private TextField pass_id;

    @FXML
    private TextField pass_id1;

    ServiceUser SU = new ServiceUser();
    @FXML
    void AddItem(ActionEvent event) throws SQLException {
        if(Validate())
        {
            User u = new User();
            u.setUser_name(nom_id.getText());
            u.setUser_pass(pass_id.getText());
            SU.add(u);
            GoBack();
        }else {
            showAlert("Password","Password does not match");
        }

    }
    private boolean Validate()
    {
        if(pass_id.getText().equals(pass_id1.getText()))
        {
            System.out.println("It is Identical");
            return true;
        }
        return false;
    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
    void goBack(ActionEvent event) {
        GoBack();
    }
    private void GoBack()
    {
        try{
            //LOAD THE PAGE
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Admin/Dashboard_Users.fxml"));
            Parent root= fxmlLoader.load();
            //CHANGE THE PAGE
            cancel_butt.getScene().setRoot(root);
        }catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

}
