package controllers.Entities.Users;

import entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import services.ServiceUser;

import java.io.IOException;
import java.sql.SQLException;

public class UserUpdate {

    @FXML
    private Pane Update_Screen_id;

    @FXML
    private TextField nom_id;

    @FXML
    private TextField pass_id;

    @FXML
    private TextField pass_id1;
    //Actual User
    private User currUser;
    ServiceUser SU = new ServiceUser();

    @FXML
    void CancelDeletion(ActionEvent event) {
        Update_Screen_id.setVisible(false);
    }

    @FXML
    void DoUpdateUser(ActionEvent event) {
        try{
            if(Validate())
            {
                User u = currUser;
                u.setUser_name(nom_id.getText());
                u.setUser_pass(pass_id.getText());
                SU.update(u);
                currUser = u;
                GoBack();
            }else {
                showAlert("Password","Password does not match");
            }
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
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
    void UpdateUser(ActionEvent event) {
        Update_Screen_id.setVisible(true);
    }

    @FXML
    void goBack(ActionEvent event) {
        GoBack();
    }
    private void GoBack()
    {
        try {
            //LOAD THE PAGE
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Entities/Users/User_Show.fxml"));
            Parent root = fxmlLoader.load();
            //Extract the Controller
            UserShow cont = fxmlLoader.getController();
            //SET THE DATA
            cont.SetData(currUser);
            //CHANGE THE PAGE
            nom_id.getScene().setRoot(root);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void SetData(User user)
    {
        currUser = user;
        nom_id.setText(user.getUser_name());
        pass_id.setText(user.getUser_pass());
        pass_id1.setText(user.getUser_pass());
    }

}
