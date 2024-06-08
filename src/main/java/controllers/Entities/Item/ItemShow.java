package controllers.Entities.Item;

import entities.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import services.ServiceItem;

import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ItemShow {

    @FXML
    private Button add_butt;

    @FXML
    private TextArea area_id;

    @FXML
    private RadioButton bois_id;

    @FXML
    private Button cancel_butt;

    @FXML
    private RadioButton crepe_id;

    @FXML
    private TextField desc_id;

    @FXML
    private TextField nom_id;

    @FXML
    private TextField price_id;

    @FXML
    private RadioButton waffle_id;

    @FXML
    private Pane Delete_Screen_id;

    private Item currItem;

    ToggleGroup group = new ToggleGroup();

    ServiceItem SI = new ServiceItem();
    @FXML
    void DeleteItem(ActionEvent event) {
        Delete_Screen_id.setVisible(true);
    }

    @FXML
    void DoDeleteTheItem(ActionEvent event) throws Exception{
        SI.delete(currItem);
        Delete_Screen_id.setVisible(false);
        GoBackScript();
    }

    @FXML
    void CancelDeletion(ActionEvent event) {
        Delete_Screen_id.setVisible(false);
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        GoBackScript();
    }
    private void GoBackScript()throws IOException
    {
        //LOAD THE PAGE
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Admin/Dashboard_Items.fxml"));
        Parent root= fxmlLoader.load();
        //CHANGE THE PAGE
        cancel_butt.getScene().setRoot(root);
    }
    @FXML
    void UpdateItem(ActionEvent event) throws IOException{
        //LOAD THE PAGE
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Entities/Item/Item_Update.fxml"));
        Parent root = fxmlLoader.load();
        //Extract the Controller
        ItemUpdate cont = fxmlLoader.getController();
        //SET THE DATA
        cont.SetData(currItem);
        //CHANGE THE PAGE
        cancel_butt.getScene().setRoot(root);
    }

    public void SetData(Item item)
    {
        //Initializing
        Delete_Screen_id.setVisible(false);
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
            crepe_id.setDisable(true);
            bois_id.setDisable(true);
        } else if (item.getType() == 2) {
            crepe_id.setSelected(true);
            //Disable the others
            waffle_id.setDisable(true);
            bois_id.setDisable(true);
        } else if (item.getType() == 3) {
            bois_id.setSelected(true);
            //Disable the others
            crepe_id.setDisable(true);
            waffle_id.setDisable(true);
        }
    }
}
