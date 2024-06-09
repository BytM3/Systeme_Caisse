package controllers;

import entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.ServiceUser;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField name_id;

    @FXML
    private TextField pass_id;

    private String name;
    private String pass;

    private final String AdminName = "Bibo";
    private final String AdminPass = "123";

    // ERROR HANDELING
    @FXML
    private Text error_id;

    ServiceUser SU = new ServiceUser();
    //LoggedOn User
    public static User connectedUser;

    @FXML
    void Login(ActionEvent event) {
        SetVariables();
        if(name_id.getText().toLowerCase().equals(AdminName.toLowerCase()) && pass_id.getText().toLowerCase().equals(AdminPass.toLowerCase()))
        {
            GoToAdminDashboard();
        }
        else if(Validate())
        {
            GoToPage();
        }
    }
    public void initialize()
    {
        error_id.setVisible(false);
        name_id.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.equals(oldValue)) {
                error_id.setVisible(false);
            }
        });

        pass_id.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.equals(oldValue)) {
                error_id.setVisible(false);
            }
        });
    }
    private boolean Validate()
    {
        User temp = SU.findUser(name);
        if(temp != null && temp.getUser_pass().toLowerCase().equals(pass))
        {
            connectedUser = temp;
            return true;
        }else {
            showAlert("ERROR","Username or Password Wrong!");
            //error_id.setVisible(true);
        }
        return false;
    }

    @FXML
    void exit(ActionEvent event) {
        Stage stage = (Stage) name_id.getScene().getWindow();
        stage.close();
    }

    private void GoToPage()
    {
        try {
            //LOAD THE PAGE
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/MainScreen.fxml"));
            Parent root= fxmlLoader.load();
            //CHANGE THE PAGE
            name_id.getScene().setRoot(root);
        }catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

    }
    private void GoToAdminDashboard()
    {
        try {
            //LOAD THE PAGE
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Admin/Dashboard_Users.fxml"));
            Parent root= fxmlLoader.load();
            //CHANGE THE PAGE
            name_id.getScene().setRoot(root);
        }catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    private void SetVariables()
    {
        name = name_id.getText().toLowerCase();
        pass = pass_id.getText().toLowerCase();
    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
