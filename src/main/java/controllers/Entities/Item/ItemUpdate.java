package controllers.Entities.Item;

import entities.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import services.ServiceItem;

import java.io.IOException;
import java.sql.SQLException;

public class ItemUpdate {

    @FXML
    private Pane Update_Screen_id;

    @FXML
    private TextArea area_id;

    @FXML
    private TextField nom_id;

    @FXML
    private TextField price_id;

    //RADIO BUTTONS
    ToggleGroup group = new ToggleGroup();

    @FXML
    private RadioButton waffle_id;

    @FXML
    private RadioButton bois_id;

    @FXML
    private RadioButton crepe_id;

    //Actual Item
    private Item currItem;
    //Service
    ServiceItem SI = new ServiceItem();

    @FXML
    void UpdateItem(ActionEvent event) {
        Update_Screen_id.setVisible(true);
    }
    @FXML
    void CancelUpdate(ActionEvent event) {
        Update_Screen_id.setVisible(false);
    }

    @FXML
    void DoUpdateItem(ActionEvent event) throws Exception {
        if(Validate())
        {
            Item updatedItem = new Item();
            updatedItem.setItem_id(currItem.getItem_id());
            updatedItem.setItem_name(nom_id.getText());
            updatedItem.setItem_desc(area_id.getText());
            updatedItem.setItem_price(Float.parseFloat(price_id.getText()));
            if(waffle_id.isSelected())
            {
                updatedItem.setType(1);
                updatedItem.setMenu_id(1);
            } else if (crepe_id.isSelected()) {
                updatedItem.setType(2);
                updatedItem.setMenu_id(1);
            } else if (bois_id.isSelected()) {
                updatedItem.setType(3);
                updatedItem.setMenu_id(2);
            }
            SI.update(updatedItem);
            Update_Screen_id.setVisible(false);
            //Change The Current Item after changing it in the DataBase
            currItem = updatedItem;
            GoBackScript();
        }
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        GoBackScript();
    }
    private void GoBackScript() throws IOException
    {
        //LOAD THE PAGE
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Entities/Item/Item_Show.fxml"));
        Parent root = fxmlLoader.load();
        //Extract the Controller
        ItemShow cont = fxmlLoader.getController();
        //SET THE DATA
        cont.SetData(currItem);
        //CHANGE THE PAGE
        bois_id.getScene().setRoot(root);
    }


    public void SetData(Item item)
    {
        //Initializing
        Update_Screen_id.setVisible(false);
        //Saving the actual item
        currItem = item;
        //Setting Basic Text
        nom_id.setText(item.getItem_name());
        area_id.setText(item.getItem_desc());
        price_id.setText(""+item.getItem_price());
        //Setting Up the Radio Buttons
        waffle_id.setToggleGroup(group);
        crepe_id.setToggleGroup(group);
        bois_id.setToggleGroup(group);
        //Selecting Which One Needs To Be Selected
        if(item.getType() == 1){
            waffle_id.setSelected(true);
        } else if (item.getType() == 2) {
            crepe_id.setSelected(true);
        } else if (item.getType() == 3) {
            bois_id.setSelected(true);
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

}
