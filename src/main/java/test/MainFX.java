package test;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class MainFX extends Application{
    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Admin/Dashboard_Items.fxml"));

        Parent root= fxmlLoader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Caisse");
        stage.show();
    }
    public static void main(String args)
    {
        launch(args);
    }
}
