package controllers;

import entities.Item;
import entities.User;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import services.ServiceItem;
import services.ServiceTicket;
import services.ServiceUser;
import javafx.scene.layout.GridPane;

import java.sql.SQLException;
import java.util.List;

public class MainScreen {
    //LoggedIn User
    User currentUser = LoginController.connectedUser;
    //User Variables
    @FXML
    private Text user_id;
    @FXML
    private Text ouvertureCaisse_id;
    @FXML
    private Text ticketAttente_id;
    @FXML
    private Text ticketToday_id;
    @FXML
    private Text totalTicket_id;
    //Numpad
    @FXML
    private Button zero;
    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button four;
    @FXML
    private Button five;
    @FXML
    private Button six;
    @FXML
    private Button seven;
    @FXML
    private Button eight;
    @FXML
    private Button nine;
    @FXML
    private Button table_num_id;

    //Boisson Tab
    @FXML
    private GridPane boiss_grid;

    private String S="";
    //Initializing Services
    ServiceUser SU = new ServiceUser();
    ServiceItem SI = new ServiceItem();
    ServiceTicket ST = new ServiceTicket();

    @FXML
    void initialize()
    {
        user_id.setText("Username : "+currentUser.getUser_name());
        ouvertureCaisse_id.setText("Ouverture de Caisse : ");
        ticketAttente_id.setText("Ticket En Attente : ");
        ticketToday_id.setText("Ticket Aujourd'hui : ");
        totalTicket_id.setText("Total Ticket : ");
        setItems();
    }

    @FXML
    void AddNumber(ActionEvent event) {
        Button  temp = (Button) event.getSource();
        System.out.println(temp.getText());
        S+=temp.getText();
        table_num_id.setText("Table : "+S);
    }

    @FXML
    void SearchForTable(ActionEvent event) {

    }

    void setItems()
    {
        int j=0;
        int s=0;
        try{
            for (int i = 0 ; i < 6 ; i++ )
            {
                if(s == 5)
                {
                    s=0;
                    j++;
                }
                Button newButt = new Button();
                boiss_grid.add(newButt,i,j);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
