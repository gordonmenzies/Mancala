package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;

public class Controller {

    private ArrayList<String> usernameList = new ArrayList<>();
    private ArrayList<String> passwordList = new ArrayList<>();
    private ArrayList<String> FirstNameList = new ArrayList<>();
    private ArrayList<String> SurnameList = new ArrayList<>();

    @FXML
    private AnchorPane ExitGameScene;
    @FXML
    private AnchorPane startScreenScene; // Start Screen
    @FXML
    private AnchorPane loginScreenScene; // Login Screen
    @FXML
    private AnchorPane leaderboardScene; // Leaderboard Screen
    @FXML
    private AnchorPane settingScene; // Setting Screen
    @FXML
    private AnchorPane PlayerProfileScene; // Player Profile Screen
    @FXML
    private AnchorPane CreateNewUserScreenScene; // Create New User Screen
    @FXML
    private AnchorPane HomeScreenMenu; // Home Screen
    @FXML
    private AnchorPane howToPlayScreenScene; // How To Play Screen
    @FXML
    private AnchorPane InvalidUsernameScreenScene; // Invalid Username Screen
    @FXML
    private AnchorPane selectGameModeScene; // Select Game Mode Screen
    @FXML
    private AnchorPane InvalidUsernameAndPasswordSScene; // No Username or Password Input Error Screen
    @FXML
    private AnchorPane usernameAlreadyExist; // No Username Already Exist Input Error Screen


    @FXML
    private Button startScreenExitButtonConfirmation; // Start Screen "Press to Start" Button ID name
    @FXML
    private Button LoginBackButton; // "Back" Button on the login Screen
    @FXML
    private Button CreateNewUserBackButton; // "Back" Button on the login Screen

    @FXML
    private RadioButton playerAccountButton; // "Back" Button on the login Screen
    // @FXML
    private RadioButton adminAccountButton; // "Back" Button on the login Screen

    // Home Screen attributes
    private Stage systemDirectory;

    // login GUI attributes
    @FXML
    private TextField username;
    @FXML
    private TextField newUsername;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField newPassword;
    @FXML
    private TextField FirstName;
    @FXML
    private TextField Surname;

    // Too Short/Long Username Error Attributes
    @FXML
    private Parent usernameErrorRoot;
    private Stage usernameStage;

    // Too Short/Long Password Error Attributes
    @FXML
    private AnchorPane shortLongPasswordScene;
    private Parent passwordErrorRoot;
    private Stage passwordStage;

    // Exit Game Confirmation GUI attributes
    private Parent exitGameRoot;
    private Stage quitStage;


    //--------------------------- Start & Home Screen Methods ---------------------------\\

    // "Exit" Button on Start Screen
    public void ExitGameButton() {

        Stage exitGameConfirm = new Stage();
        exitGameConfirm = (Stage) startScreenScene.getScene().getWindow();
        System.out.println("GAME EXITED!");
        exitGameConfirm.close();
    }

    // Home Screen Menu
    public void SystemDirectory() throws Exception {

        // Builds the system home Screen
        Parent root = FXMLLoader.load(getClass().getResource("SystemDirectory.fxml"));
        systemDirectory = new Stage();
        systemDirectory.setTitle("System Directory");

        // Removes the Minimize, Maximize & Close window buttons
        systemDirectory.resizableProperty().setValue(false);
        systemDirectory.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("129733589_219951142869744_4743562922763074713_n.png"); // Select a Icon image for the Display top left conner of the screen
        systemDirectory.getIcons().add(systemIcon);

        // Displays the Home Screen
        systemDirectory.setScene(new Scene(root));
        systemDirectory.show();
    }

    // Exit Game Confirmation Screen after quit Button
    public void quit() throws Exception {

        // Exit Game Confirmation Screen properties
        exitGameRoot = FXMLLoader.load(getClass().getResource("quitConfirmation.fxml"));
        quitStage = new Stage();

        // Hides the Minimize, Maximize & Close window buttons
        quitStage.resizableProperty().setValue(false);
        quitStage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("129733589_219951142869744_4743562922763074713_n.png"); // Select a Icon image for the Display top left conner of the screen
        quitStage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        quitStage.setResizable(false);

        // Display the Exit Game Confirmation Screen
        quitStage.setScene(new Scene(exitGameRoot));
        quitStage.show();
    }

    // "Yes" Button on Exit Game Confirmation Screen
    public void YesExitGame() {

        // Closes the "Exit Game" pop-up confirmation screen
        quitStage = (Stage) ExitGameScene.getScene().getWindow();
        System.out.println("Successfully Exited the Game");
        quitStage.close();
    }

    // "No" Button on Exit Game Confirmation Screen
    public void noExitGame() {

        quitStage = (Stage) ExitGameScene.getScene().getWindow();
        System.out.println("Successfully continued the Game");
        quitStage.close();
    }

    // Close's the Home Screen
    public void exitHomeScreen() {

        // Closes the Home Screen Menu
        Stage quitHomeScreenMenu = new Stage();
        quitHomeScreenMenu = (Stage) HomeScreenMenu.getScene().getWindow();
        quitHomeScreenMenu.close();
    }

    //--------------------------- Login Methods ---------------------------\\

    // login Screen
    public void login() throws Exception {

        // Login Menu GUI properties
        Parent root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
        Stage loginStage = new Stage();

        // Removes the Minimize, Maximize & Close window buttons
        loginStage.resizableProperty().setValue(false);
        loginStage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("129733589_219951142869744_4743562922763074713_n.png"); // Select a Icon image for the Display top left conner of the screen
        loginStage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        loginStage.setResizable(false);

        // Displays the Login Screen
        loginStage.setScene(new Scene(root));
        loginStage.show();
    }

    // No Username & password Input
    public void validLoginInput() throws Exception {

        // If No input in the Username & Password TextField
        if (username.getLength() == 0 && password.getLength() == 0) {
            System.out.println("Login Error");
            EmptyUsernameAndPassword();

            // If Username & Password Input TextField is Invalid
        } else if (username.getLength() < 3 || username.getLength() > 10 && password.getLength() < 8 || password.getLength() > 20) {
            System.out.println("Login Error");
            EmptyUsernameAndPassword();

        } else {

            usernameList.add("Todd");
            usernameList.add("Owen");
            usernameList.add("Jake");
            usernameList.add("Sam");

            // User Account verification
            int count = 0;
            for (String usernameFound : usernameList) {

                count++;
                if (usernameFound.contains(username.getText())) {
                    System.out.println("Found");

                    // Builds the Home Screen
                    SystemDirectory();

                    // Close's the Login Screen when the select Game Mode screen is created
                    Stage selectGameModeStage = new Stage();
                    selectGameModeStage = (Stage) loginScreenScene.getScene().getWindow();
                    System.out.println("Successfully Exited the out of Login Screen");
                    selectGameModeStage.close();

                    break; // Stop's the database Search when username is found.

                } else if (count == usernameList.size()) {
                    System.out.println("Finished");
                    EmptyUsernameAndPassword();
                }
            }
        }
    }

    // "Back" Button on the login Screen
    public void loginBackButton() {

        // Login Menu GUI properties
        Stage exitloginConfirm = new Stage();
        exitloginConfirm = (Stage) loginScreenScene.getScene().getWindow();
        System.out.println("Successfully Exited the Login Screen");
        exitloginConfirm.close();
    }

    // Get Username Input
    public  void getUsername(){
        username.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("\n" + "Username Entered: " + username.getText()); // Confirmation of username Text Input

                // Username length verification (Long/Short)
                if(username.getLength() < 3){

                    System.out.println("Password Length: " + username.getLength());
                    try {
                        tooShortUsername();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else if (username.getLength() > 10){

                    System.out.println("Password Length: " + username.getLength());
                    try {
                        tooLongUsername();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    // Too Short Username Error method
    public void tooShortUsername() throws Exception {

        // Too Short Username GUI properties
        usernameErrorRoot = FXMLLoader.load(getClass().getResource("tooShortUsername.fxml"));
        usernameStage = new Stage();

        // Removes the Minimize, Maximize & Close window buttons
        usernameStage.resizableProperty().setValue(false);
        usernameStage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("129733589_219951142869744_4743562922763074713_n.png"); // Select a Icon image for the Display top left conner of the screen
        usernameStage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        usernameStage.setResizable(false);

        // Display the too short Username GUI
        usernameStage.setScene(new Scene(usernameErrorRoot));
        usernameStage.show();
    }

    // Too Long Username Error method
    public void tooLongUsername() throws Exception {

        // Too Long Username GUI properties
        usernameErrorRoot = FXMLLoader.load(getClass().getResource("tooLongUsername.fxml"));
        usernameStage = new Stage();

        // Removes the Minimize, Maximize & Close window buttons
        usernameStage.resizableProperty().setValue(false);
        usernameStage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("129733589_219951142869744_4743562922763074713_n.png"); // Select a Icon image for the Display top left conner of the screen
        usernameStage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        usernameStage.setResizable(false);

        // Display the too Long Username GUI
        usernameStage.setScene(new Scene(usernameErrorRoot));
        usernameStage.show();
    }

    // Get input password
    public  void getPassword(){
        password.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("\n" + "Password Entered: " + password.getText()); // Confirmation of password Text Input

                // Password length verification (Long/Short)
                if(password.getLength() < 8){

                    System.out.println("Password Length: " + password.getLength());
                    try {
                        tooShortPassword();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else if (password.getLength() > 20){

                    System.out.println("Password Length: " + password.getLength());
                    try {
                        tooLongPassword();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    // Too Short Password Error method
    public void tooShortPassword() throws Exception {

        // Exit Game Confirmation GUI properties
        passwordErrorRoot = FXMLLoader.load(getClass().getResource("tooShortPassword.fxml"));
        passwordStage = new Stage();

        // Removes the Minimize, Maximize & Close window buttons
        passwordStage.resizableProperty().setValue(false);
        passwordStage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("129733589_219951142869744_4743562922763074713_n.png"); // Select a Icon image for the Display top left conner of the screen
        passwordStage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        passwordStage.setResizable(false);

        // Display the Exit Game Confirmation GUI
        passwordStage.setScene(new Scene(passwordErrorRoot));
        passwordStage.show();
    }

    // Too Long Password Error method
    public void tooLongPassword() throws Exception {

        // Exit Game Confirmation GUI properties
        passwordErrorRoot = FXMLLoader.load(getClass().getResource("tooLongPassword.fxml"));
        passwordStage = new Stage();

        // Removes the Minimize, Maximize & Close window buttons
        passwordStage.resizableProperty().setValue(false);
        passwordStage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("129733589_219951142869744_4743562922763074713_n.png"); // Select a Icon image for the Display top left conner of the screen
        passwordStage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        passwordStage.setResizable(false);

        // Display the Exit Game Confirmation GUI
        passwordStage.setScene(new Scene(passwordErrorRoot));
        passwordStage.show();
    }

    // "OK" Button on Too Short Password Error Screen
    public void passwordReattemptOKButton() {

        passwordStage = (Stage) shortLongPasswordScene.getScene().getWindow();
        System.out.println("Successful Password Re-attempt");
        passwordStage.close();
    }

    // "Ok" Button on the Invalid Username Screen
    public void InvalidUsernameOkButton() {

        // Invalid Username GUI properties
        Stage usernameReattempt = new Stage();
        usernameReattempt = (Stage) InvalidUsernameScreenScene.getScene().getWindow();
        System.out.println("Username Re-attempt");
        usernameReattempt.close();
    }

    //--------------------------- No Username & Password Screen Methods ---------------------------\\

    // Error Screen When No Username & Password
    public void EmptyUsernameAndPassword() throws Exception {

        // No User Input properties
        Parent root = FXMLLoader.load(getClass().getResource("NoUserInput.fxml"));
        Stage NoUserInput = new Stage();

        // Removes the Minimize, Maximize & Close window buttons
        NoUserInput.resizableProperty().setValue(false);
        NoUserInput.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("129733589_219951142869744_4743562922763074713_n.png"); // Select a Icon image for the Display top left conner of the screen
        NoUserInput.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        NoUserInput.setResizable(false);

        // Display the No User Input Screen
        NoUserInput.setScene(new Scene(root));
        NoUserInput.show();
    }

    // Error Screen When No Username Already Exist
    public void UsernameAlreadyExist() throws Exception {

        // No User Input properties
        Parent root = FXMLLoader.load(getClass().getResource("NoUserInput.fxml"));
        Stage NoUserInput = new Stage();

        // Removes the Minimize, Maximize & Close window buttons
        NoUserInput.resizableProperty().setValue(false);
        NoUserInput.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("129733589_219951142869744_4743562922763074713_n.png"); // Select a Icon image for the Display top left conner of the screen
        NoUserInput.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        NoUserInput.setResizable(false);

        // Display the No User Input Screen
        NoUserInput.setScene(new Scene(root));
        NoUserInput.show();
    }

    // The 'OK' Button on the Invalid Username & Password Reattempt Screen
    public void LoginAndCreateNewUserReattempt(){

        Stage exitloginConfirm = new Stage();
        exitloginConfirm = (Stage) InvalidUsernameAndPasswordSScene.getScene().getWindow();
        System.out.println("Login Re-Attempt Executed");
        exitloginConfirm.close();
    }

    // The 'OK' Button on the Invalid Username & Password Reattempt Screen
    public void UsernameAlreadyExistReattempt(){

        Stage usernameAlreadyExistStage = new Stage();
        usernameAlreadyExistStage = (Stage) usernameAlreadyExist.getScene().getWindow();
        System.out.println("Create New User Re-Attempt Executed");
        usernameAlreadyExistStage.close();
    }

    //--------------------------- How to Play Screen Methods ---------------------------\\

    // How to Play Screen
    public void howToPlay() throws Exception {

        // How to Play Menu GUI properties
        Parent root = FXMLLoader.load(getClass().getResource("howToPlay.fxml"));
        Stage howToPlayStage = new Stage();

        // Removes the Minimize, Maximize & Close window buttons
        howToPlayStage.resizableProperty().setValue(false);
        howToPlayStage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("129733589_219951142869744_4743562922763074713_n.png"); // Select a Icon image for the Display top left conner of the screen
        howToPlayStage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        howToPlayStage.setResizable(false);

        // Displays the How to Play Screen
        howToPlayStage.setScene(new Scene(root));
        howToPlayStage.show();
    }

    // "Back" Button on How To Play Screen
    public void exitHowToPlay() {

        Stage gameRules = new Stage();
        gameRules = (Stage) howToPlayScreenScene.getScene().getWindow();
        System.out.println("Successfully Exited the How To Play Screen");
        gameRules.close();
    }

    //--------------------------- Create New User Screen Methods ---------------------------\\

    // Create New User Screen
    public void createNewUser() throws Exception {

        // Builds the system home Screen
        Parent root = FXMLLoader.load(getClass().getResource("CreateNewUser.fxml"));
        Stage newUserStage = new Stage();
        newUserStage.setTitle("System Directory");

        // Removes the Minimize, Maximize & Close window buttons
        newUserStage.resizableProperty().setValue(false);
        newUserStage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("129733589_219951142869744_4743562922763074713_n.png"); // Select a Icon image for the Display top left conner of the screen
        newUserStage.getIcons().add(systemIcon);

        // Displays the Create New User Screen
        newUserStage.setScene(new Scene(root));
        newUserStage.show();

    }

    // New User, No Username & password valid Input
    public void validCreateNewUserInput() throws Exception {

        // If No input in the First Name, Surname, Username & Password TextField Error Message
        if (FirstName.getLength() == 0 && Surname.getLength() == 0 && newUsername.getLength() == 0 && newPassword.getLength() == 0){
            System.out.println("Data Input Error");
            EmptyUsernameAndPassword();

            // If Username & Password Input TextField is Invalid
        } else if (FirstName.getLength() < 1 || FirstName.getLength() > 10 && Surname.getLength() < 1 || Surname.getLength() > 20 || newUsername.getLength() < 3 || newUsername.getLength() > 10 && newPassword.getLength() < 8 || newPassword.getLength() > 20) {
            System.out.println("Data Input Error");
            EmptyUsernameAndPassword();

        } else {

            usernameList.add("Todd");
            usernameList.add("Owen");
            usernameList.add("Jake");
            usernameList.add("Sam");

            // User Account verification
            int count = 0;
            for (String usernameFound : usernameList) {

                count++;
                if (usernameFound.contains(newUsername.getText())) {
                    System.out.println("Found");
                    UsernameAlreadyExistReattempt();
                    break; // Stop's the database Search when username is found.

                } else if (count == usernameList.size()) {

                    // Adds a new Username & the new Username password into the Database
                    System.out.println("New User Information Added to Database");
                    FirstNameList.add(FirstName.getText());
                    SurnameList.add(Surname.getText());
                    usernameList.add(newUsername.getText());
                    passwordList.add(newPassword.getText());

                    // Builds the Home Screen
                    SystemDirectory();

                    // Close's the Create New User Screen, when the select Game Mode screen is created
                    Stage selectGameModeStage = new Stage();
                    selectGameModeStage = (Stage) CreateNewUserScreenScene.getScene().getWindow();
                    System.out.println("Successfully Exited the out of Create New User Screen");
                    selectGameModeStage.close();
                }
            }
        }
    }

    // Get input Username
    public  void getNewUsername(){
        newUsername.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("\n" + "Username Entered: " + newUsername.getText()); // Confirmation of username Text Input

                // Username length verification (Long/Short)
                int usernameLength = newUsername.getLength();

                if(usernameLength < 3){

                    System.out.println("Password Length: " + usernameLength);
                    try {
                        tooShortNewUsername();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else if (usernameLength > 10){

                    System.out.println("Password Length: " + usernameLength);
                    try {
                        tooLongNewUsername();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    // Too Short New Username Error method
    public void tooShortNewUsername() throws Exception {

        // Too Short New Username GUI properties
        Parent newUsernameRoot = FXMLLoader.load(getClass().getResource("tooShortUsername.fxml"));
        Stage newUsernameStage = new Stage();

        // Removes the Minimize, Maximize & Close window buttons
        newUsernameStage.resizableProperty().setValue(false);
        newUsernameStage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("129733589_219951142869744_4743562922763074713_n.png"); // Select a Icon image for the Display top left conner of the screen
        newUsernameStage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        newUsernameStage.setResizable(false);

        // Display the too short New Username GUI
        newUsernameStage.setScene(new Scene(newUsernameRoot));
        newUsernameStage.show();
    }

    // Too Long Username Error method
    public void tooLongNewUsername() throws Exception {

        // Too Long Username GUI properties
        Parent newUsernameRoot = FXMLLoader.load(getClass().getResource("tooLongUsername.fxml"));
        Stage newUsernameStage = new Stage();

        // Removes the Minimize, Maximize & Close window buttons
        newUsernameStage.resizableProperty().setValue(false);
        newUsernameStage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("129733589_219951142869744_4743562922763074713_n.png"); // Select a Icon image for the Display top left conner of the screen
        newUsernameStage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        newUsernameStage.setResizable(false);

        // Display the too Long Username GUI
        newUsernameStage.setScene(new Scene(newUsernameRoot));
        newUsernameStage.show();
    }

    // Get New password input
    public  void getNewPassword(){
        newPassword.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("\n" + "Password Entered: " + newPassword.getText()); // Confirmation of password Text Input

                // Password length verification (Long/Short)
                int passwordLength = newPassword.getLength();
                if(passwordLength < 8){

                    System.out.println("Password Length: " + passwordLength);
                    try {
                        tooShortNewPassword();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else if (passwordLength > 20){

                    System.out.println("Password Length: " + passwordLength);
                    try {
                        tooLongNewPassword();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    // Too Short New Password Error method
    public void tooShortNewPassword() throws Exception {

        // Exit Game Confirmation GUI properties
        Parent newPasswordRoot = FXMLLoader.load(getClass().getResource("tooShortPassword.fxml"));
        Stage newPasswordStage = new Stage();

        // Removes the Minimize, Maximize & Close window buttons
        newPasswordStage.resizableProperty().setValue(false);
        newPasswordStage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("129733589_219951142869744_4743562922763074713_n.png"); // Select a Icon image for the Display top left conner of the screen
        newPasswordStage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        newPasswordStage.setResizable(false);

        // Display the Exit Game Confirmation GUI
        newPasswordStage.setScene(new Scene(newPasswordRoot));
        newPasswordStage.show();
    }

    // Too Long New Password Error method
    public void tooLongNewPassword() throws Exception {
        // Exit Game Confirmation GUI properties
        Parent newPasswordRoot = FXMLLoader.load(getClass().getResource("tooLongPassword.fxml"));
        Stage newPasswordStage = new Stage();

        // Removes the Minimize, Maximize & Close window buttons
        newPasswordStage.resizableProperty().setValue(false);
        newPasswordStage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("129733589_219951142869744_4743562922763074713_n.png"); // Select a Icon image for the Display top left conner of the screen
        newPasswordStage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        newPasswordStage.setResizable(false);

        // Display the Exit Game Confirmation GUI
        newPasswordStage.setScene(new Scene(newPasswordRoot));
        newPasswordStage.show();
    }

    // "OK" Button for re-attempting Invalid Create New User Input Error Screen
    public void CreateNewUserReattempt() {

        Stage exitloginConfirm = new Stage();
        exitloginConfirm = (Stage) InvalidUsernameAndPasswordSScene.getScene().getWindow();
        System.out.println("Successful Login Re-Attempt");
        exitloginConfirm.close();
    }

    // Exits the Create the New User Screen Back to the Login Screen
    public void exitCreateNewUserScreen() throws Exception {

        // Create New User Screen properties
        Stage exitloginConfirm = new Stage();
        exitloginConfirm = (Stage) CreateNewUserScreenScene.getScene().getWindow();
        System.out.println("Successfully Exited the out of Create New User Screen");
        exitloginConfirm.close();
    }

    //--------------------------- Setting Screen Methods ---------------------------\\

    // Setting Screen
    public void Setting() throws Exception {

        // Setting Menu GUI properties
        Parent root = FXMLLoader.load(getClass().getResource("Setting.fxml"));
        Stage settingStage = new Stage();

        // Removes the Minimize, Maximize & Close window buttons
        settingStage.resizableProperty().setValue(false);
        settingStage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("129733589_219951142869744_4743562922763074713_n.png"); // Select a Icon image for the Display top left conner of the screen
        settingStage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        settingStage.setResizable(false);

        settingStage.setScene(new Scene(root));
        settingStage.show();

    }

    // Exits the Setting Screen Back to the Home Screen
    public void exitSetting() {

        // Setting GUI properties
        Stage settingStage = new Stage();
        settingStage = (Stage) settingScene.getScene().getWindow();
        System.out.println("Successfully Exited the out of Setting Screen");
        settingStage.close();
    }

    //--------------------------- leaderboard Screen Methods ---------------------------\\

    // leaderboard Screen
    public void leaderboard() throws Exception {

        // Setting Menu GUI properties
        Parent root = FXMLLoader.load(getClass().getResource("leaderboard.fxml"));
        Stage settingStage = new Stage();

        // Removes the Minimize, Maximize & Close window buttons
        settingStage.resizableProperty().setValue(false);
        settingStage.initStyle(StageStyle.UNDECORATED);


        // Screen Icon properties
        Image systemIcon = new Image("129733589_219951142869744_4743562922763074713_n.png"); // Select a Icon image for the Display top left conner of the screen
        settingStage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        settingStage.setResizable(false);

        settingStage.setScene(new Scene(root));
        settingStage.show();

    }

    // Exits the leaderboard Screen Back to the Home Screen
    public void exitLeaderboard() {

        // leaderboard GUI properties
        Stage leaderboardStage = new Stage();
        leaderboardStage = (Stage) leaderboardScene.getScene().getWindow();
        System.out.println("Successfully Exited the out of leaderboard Screen");
        leaderboardStage.close();
    }

    //--------------------------- System Setting Screen Methods ---------------------------\\

    // Select Game Mode Screen
    public void selectGameMode() throws Exception {

        // Select Game Mode GUI properties
        Parent root = FXMLLoader.load(getClass().getResource("selectGameMode.fxml"));
        Stage gameModeStage = new Stage();

        // Removes the Minimize, Maximize & Close window buttons
        gameModeStage.resizableProperty().setValue(false);
        gameModeStage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("129733589_219951142869744_4743562922763074713_n.png"); // Select a Icon image for the Display top left conner of the screen
        gameModeStage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        gameModeStage.setResizable(false);

        // Select Game Mode GUI to visible
        gameModeStage.setScene(new Scene(root));
        gameModeStage.show();

    }

    // Exits the select Game Mode Screen Back to the Home Screen
    public void exitSelectGameMode() {

        // Create New User GUI properties
        Stage selectGameModeStage = new Stage();
        selectGameModeStage = (Stage) selectGameModeScene.getScene().getWindow();
        System.out.println("Successfully Exited the Select Game Mode Screen");
        selectGameModeStage.close();
    }

    //--------------------------- Player Profile Screen Methods ---------------------------\\

    // Player Profile Screen
    public void viewPlayerProfile() throws Exception {

        // Player Profile Screen properties
        Parent root = FXMLLoader.load(getClass().getResource("PlayerProfile.fxml"));
        Stage playerProfileStage = new Stage();

        // Removes the Minimize, Maximize & Close window buttons
        playerProfileStage.resizableProperty().setValue(false);
        playerProfileStage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("129733589_219951142869744_4743562922763074713_n.png"); // Select a Icon image for the Display top left conner of the screen
        playerProfileStage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        playerProfileStage.setResizable(false);

        // Display's Player Profile Screen
        playerProfileStage.setScene(new Scene(root));
        playerProfileStage.show();
    }

    // Exits the Player Profile Screen Back to the Home Screen
    public void exitPlayerProfile() {

        // Player Profile Screen properties
        Stage playerProfileStage = new Stage();
        playerProfileStage = (Stage) PlayerProfileScene.getScene().getWindow();
        System.out.println("Successfully Exited the out of Player Profile Screen");
        playerProfileStage.close();
    }
}
