package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage startScreen) throws Exception{
        try {
            // Builds the Start Screen
            Parent root = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
            startScreen.setTitle("System Directory");
            startScreen.setResizable(false);

            // Removes the Minimize, Maximize & Close window buttons
            startScreen.resizableProperty().setValue(false);
            startScreen.initStyle(StageStyle.UNDECORATED);

            // Screen Icon properties
            Image systemIcon = new Image("129733589_219951142869744_4743562922763074713_n.png"); // Select a Icon image for the Display top left conner of the screen
            startScreen.getIcons().add(systemIcon);

            // Displays the Start Screen
            startScreen.setScene(new Scene(root));
            startScreen.show();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}