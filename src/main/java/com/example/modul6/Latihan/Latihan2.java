package com.example.modul6.Latihan;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.Button;

public class Latihan2 extends Application {
    private TableView<Mahasiswa> table = new TableView<>();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new Group());
        stage.setTitle("Test TableView");
        stage.setWidth(650);
        stage.setHeight(750);

        final Label label = new Label("Daftar Mahasiswa");
        label.setFont(new Font("Arial", 30));

        table.setEditable(true);

        TableColumn namaCol = new TableColumn<>("Nama");
        TableColumn NIMCol = new TableColumn<>("NIM");
        TableColumn emailCol = new TableColumn<>("Email");

        namaCol.setMinWidth(200);
        NIMCol.setMinWidth(150);
        emailCol.setMinWidth(250);

        table.getColumns().addAll(namaCol, NIMCol, emailCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(8);
        vbox.setPadding(new Insets(20, 10, 10, 10));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
        final ObservableList<Mahasiswa> data = FXCollections.observableArrayList(
                new Mahasiswa("M. Darma Putra Ramadhan", "202210370311375", "darmaputra@webmail.umm.ac.id"),
                new Mahasiswa("Abdul Salam", "202210370311376", "abdulsalam@webmail.umm.ac.id"), new Mahasiswa("Andika Salsabilah", "202210370311402", "andikaS@webmail.umm.ac.id"), new Mahasiswa("Rusdany Maestro", "202210370311406", "rusdanyM@webmail.umm.ac.id")
        );
        namaCol.setCellValueFactory(
                new PropertyValueFactory<Mahasiswa, String>("nama")
        );
        NIMCol.setCellValueFactory(
                new PropertyValueFactory<Mahasiswa, String>("NIM")
        );
        emailCol.setCellValueFactory(
                new PropertyValueFactory<Mahasiswa, String>("email")
        );
        table.setItems(data);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        final TextField addName = new TextField();
        addName.setMaxWidth(namaCol.getPrefWidth());
        addName.setPromptText("Nama Mahasiswa");

        final TextField addNIM = new TextField();
        addNIM.setMaxWidth(NIMCol.getPrefWidth());
        addNIM.setPromptText("NIM");

        final TextField addemail = new TextField();
        addemail.setMaxWidth(emailCol.getPrefWidth());
        addemail.setPromptText("Email");

        final Button addbutton = new Button("Add");
        addbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!addName.getText().equalsIgnoreCase("") && !addNIM.getText().equalsIgnoreCase("") && !addemail.getText().equalsIgnoreCase("")) {
                    data.add(new Mahasiswa(
                            addName.getText(),
                            addNIM.getText(),
                            addemail.getText()
                    ));
                    addemail.clear();
                    addNIM.clear();
                    addName.clear();
                } else {
                    showEmptyFieldAlert();
                }
            }
        });

        final Button ClearAllbutton = new Button("Clear All");
        ClearAllbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                data.clear();
            }
        });

        final Button Clearbutton = new Button("Clear");
        Clearbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                table.getItems().removeAll(
                        table.getSelectionModel().getSelectedItems());
            }
        });

        final HBox hBoxinput = new HBox();

        hBoxinput.getChildren().addAll(addName, addNIM, addemail, addbutton, Clearbutton, ClearAllbutton);
        hBoxinput.setSpacing(10);

        if (!vbox.getChildren().contains(hBoxinput)) {
            vbox.getChildren().add(hBoxinput);
        }
    }

    private void showEmptyFieldAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Peringatan");
        alert.setHeaderText(null);
        alert.setContentText("Nama, NIM, dan Email tidak boleh kosong!");
        alert.showAndWait();
    }
}

