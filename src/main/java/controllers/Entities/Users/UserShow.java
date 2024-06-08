package controllers.Entities.Users;

import entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import services.ServiceUser;

import java.io.IOException;
import java.sql.SQLException;

public class UserShow {
    @FXML
    private Pane Delete_Screen_id;

    @FXML
    private TextField nom_id;

    @FXML
    private TextField pass_id;
    //Actual User
    private User currUser;

    ServiceUser SU = new ServiceUser();

    @FXML
    void Cancel(ActionEvent event) {
        GoBack();
    }

    @FXML
    void DeleteFunc(ActionEvent event) {
        Delete_Screen_id.setVisible(true);
    }

    @FXML
    void DoDeleteUser(ActionEvent event) {
        try {
            SU.delete(currUser);
            GoBack();
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    private void GoBack()
    {
        try{
            //LOAD THE PAGE
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Admin/Dashboard_Users.fxml"));
            Parent root= fxmlLoader.load();
            //CHANGE THE PAGE
            nom_id.getScene().setRoot(root);
        }catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void CancelDeletion(ActionEvent event) {
        Delete_Screen_id.setVisible(false);
    }

    @FXML
    void UpdateFunc(ActionEvent event) {
        try {
            //LOAD THE PAGE
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Entities/Users/User_Update.fxml"));
            Parent root = fxmlLoader.load();
            //Extract the Controller
            UserUpdate cont = fxmlLoader.getController();
            //SET THE DATA
            cont.SetData(currUser);
            //CHANGE THE PAGE
            Delete_Screen_id.getScene().setRoot(root);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void SetData(User user)
    {
        currUser = user;
        nom_id.setText(user.getUser_name());
        pass_id.setText(user.getUser_pass());

        Delete_Screen_id.setVisible(false);
    }

}
