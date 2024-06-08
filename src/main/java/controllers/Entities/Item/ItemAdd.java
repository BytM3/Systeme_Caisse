package controllers.Entities.Item;

import entities.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import services.ServiceItem;
import services.ServiceMenu;

import java.io.IOException;
import javafx.scene.control.TextArea;

public class ItemAdd {

    @FXML
    private Button add_butt;

    @FXML
    private RadioButton bois_id;

    @FXML
    private Button cancel_butt;

    @FXML
    private RadioButton crepe_id;

    @FXML
    private TextArea  desc_id;

    @FXML
    private TextField nom_id;

    @FXML
    private TextField price_id;

    @FXML
    private RadioButton waffle_id;

    //INITIALIZE
    ServiceItem SI = new ServiceItem();
    ServiceMenu SM = new ServiceMenu();

    @FXML
    void AddItem(ActionEvent event) throws Exception {
        if(Validate())
        {
            Item item = new Item();
            item.setItem_name(nom_id.getText());
            item.setItem_desc(desc_id.getText());

            String price = price_id.getText();
            item.setItem_price(Float.parseFloat(price));
            if(waffle_id.isSelected())
            {
                item.setType(1);
                item.setMenu_id(1);
            } else if (crepe_id.isSelected()) {
                item.setType(2);
                item.setMenu_id(1);
            } else if (bois_id.isSelected()) {
                item.setType(3);
                item.setMenu_id(2);
            }

            SI.add(item);

            System.out.println("Added an Item");
            GoBack();
        }
    }
    private boolean Validate()
    {
        if(isValidPrice(price_id.getText()))
        {
            return true;
        }else {
            showAlert("Price Is Wrong","Check Price Section and make it valid");
        }

        return false;
    }
    private boolean isValidPrice(String price) {
        // Regular expression to check if the string contains only numbers and at most one decimal point
        String regex = "\\d+(\\.\\d{1,3})?";
        return price.matches(regex);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void goBack(ActionEvent event) throws IOException{
        GoBack();
    }
    private void GoBack()throws IOException
    {
        //LOAD THE PAGE
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Admin/Dashboard_Items.fxml"));
        Parent root= fxmlLoader.load();
        //CHANGE THE PAGE
        cancel_butt.getScene().setRoot(root);
    }
    @FXML
    void initialize()
    {
        ToggleGroup group = new ToggleGroup();
        bois_id.setToggleGroup(group);
        waffle_id.setToggleGroup(group);
        crepe_id.setToggleGroup(group);
    }

}
