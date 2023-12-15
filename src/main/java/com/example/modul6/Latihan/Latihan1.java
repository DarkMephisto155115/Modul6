package com.example.modul6.Latihan;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Latihan1 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Form Login");
        stage.show();
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        Scene scene = new Scene(gridPane, 300, 275);
        stage.setScene(scene);

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        gridPane.add(scenetitle, 0, 0, 2, 1);
        Label userName = new Label("User Name : ");
        gridPane.add(userName, 0, 1);

        TextField userTextField = new TextField();
        gridPane.add(userTextField, 1, 1);

        Label password = new Label("Password : ");
        gridPane.add(password, 0, 2);

        PasswordField passBox = new PasswordField();
        gridPane.add(passBox, 1, 2);

        Button btn = new Button("Sign In");
        HBox hbtn = new HBox(10);
        hbtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbtn.getChildren().add(btn);
        gridPane.add(hbtn, 1, 4);

        final Text actiontarget = new Text();
        gridPane.add(actiontarget, 1, 6);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Sign In button Pressed");
            }
        });

    }


    public static void main(String[] args) {
        launch();
    }
}