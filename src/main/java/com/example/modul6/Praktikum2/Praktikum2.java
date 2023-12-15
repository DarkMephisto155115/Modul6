package com.example.modul6.Praktikum2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Praktikum2 extends Application {
    private TableView<Dosen> table = new TableView<>();
    private TextField addName;
    private TextField addGKB;
    private TextField addMataKuliah;
    private TextField addWaktu;
    private TextField addRuangan;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox formLayout = createFormLayout(primaryStage);
        Scene formScene = new Scene(formLayout, 420, 300);

        VBox tableLayout = createTableLayout(primaryStage, formScene);
        Scene tableScene = new Scene(tableLayout, 420, 400);

        primaryStage.setTitle("Form - Jadwal Dosen");
        primaryStage.setScene(formScene);
        primaryStage.show();

        Button switchToTableButton = new Button("Read");
        switchToTableButton.setPrefWidth(100);
        switchToTableButton.setOnAction(event -> {
            primaryStage.setScene(tableScene);
            primaryStage.setTitle("TableView - Jadwal Dosen");
        });

        Button addButton = new Button("Create");
        addButton.setPrefWidth(100);
        addButton.setOnAction(event -> {
            if (validateInput()) {
                Dosen dosen = new Dosen(
                        addName.getText(),
                        addGKB.getText(),
                        addWaktu.getText(),
                        addRuangan.getText(), addMataKuliah.getText());
                table.getItems().add(dosen);
                addName.clear();
                addGKB.clear();
                addMataKuliah.clear();
                addWaktu.clear();
                addRuangan.clear();
                CreatItemDone();
            } 
        });

        formLayout.getChildren().addAll(addButton, switchToTableButton);
    }

    private VBox createFormLayout(Stage primaryStage) {
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10, 10, 10, 10));

        Label label = new Label("Form Data Jadwal Dosen");
        label.setFont(new Font("Arial", 20));

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(5);

        Label Nama = new Label("Nama Dosen  :");
        Nama.setFont(new Font("Arial", 12));
        GridPane.setConstraints(Nama, 0, 0);

        Label mataKuliah = new Label("Mata Kuliah  :");
        mataKuliah.setFont(new Font("Arial", 12));
        GridPane.setConstraints(mataKuliah, 0, 1);

        Label GKB = new Label("GKB        :");
        GKB.setFont(new Font("Arial", 12));
        GridPane.setConstraints(GKB, 0, 2);

        Label waktu = new Label("Waktu   :");
        waktu.setFont(new Font("Arial", 12));
        GridPane.setConstraints(waktu, 0, 3);

        Label ruangan = new Label("Ruangan  :");
        ruangan.setFont(new Font("Arial", 12));
        GridPane.setConstraints(ruangan, 0, 4);

        addName = new TextField();
        addName.setPromptText("Nama Dosen");
        addName.setPrefWidth(300);
        addName.setFont(Font.font(15));
        GridPane.setConstraints(addName, 1, 0);

        addMataKuliah = new TextField();
        addMataKuliah.setPromptText("Mata Kuliah");
        addMataKuliah.setPrefWidth(300);
        addMataKuliah.setFont(Font.font(15));
        GridPane.setConstraints(addMataKuliah, 1, 1);

        addGKB = new TextField();
        addGKB.setPromptText("Gedung GKB");
        addGKB.setPrefWidth(200);
        addGKB.setFont(Font.font(15));
        GridPane.setConstraints(addGKB, 1, 2);

        addWaktu = new TextField();
        addWaktu.setPromptText("Waktu");
        addWaktu.setPrefWidth(300);
        addWaktu.setFont(Font.font(15));
        GridPane.setConstraints(addWaktu, 1, 3);

        addRuangan = new TextField();
        addRuangan.setPromptText("Ruangan");
        addRuangan.setPrefWidth(300);
        addRuangan.setFont(Font.font(15));
        GridPane.setConstraints(addRuangan, 1, 4);

        gridPane.getChildren().addAll(Nama, mataKuliah, GKB, waktu, ruangan,addName, addGKB, addMataKuliah, addWaktu, addRuangan);
        vbox.getChildren().addAll(label, gridPane);

        return vbox;
    }

    private VBox createTableLayout(Stage primaryStage, Scene formScene) {
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10, 10, 10, 10));

        Label label = new Label("Daftar Jadwal Dosen");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        final ObservableList<Dosen> data = FXCollections.observableArrayList();
        TableColumn<Dosen, String> namaCol = new TableColumn<>("Nama");
        TableColumn<Dosen, String> mataKuliahCol = new TableColumn<>("Mata Kuliah");
        TableColumn<Dosen, String> GKBlCol = new TableColumn<>("GKB");
        TableColumn<Dosen, String> waktuCol = new TableColumn<>("Waktu");
        TableColumn<Dosen, String> ruanganCol = new TableColumn<>("Ruangan");
        namaCol.setCellValueFactory(new PropertyValueFactory<>("nama"));
        mataKuliahCol.setCellValueFactory(new PropertyValueFactory<>("mataKuliah"));
        GKBlCol.setCellValueFactory(new PropertyValueFactory<>("GKB"));
        waktuCol.setCellValueFactory(new PropertyValueFactory<>("waktu"));
        ruanganCol.setCellValueFactory(new PropertyValueFactory<>("ruangan"));
        table.setItems(data);
        table.getColumns().addAll(namaCol, mataKuliahCol, GKBlCol, waktuCol, ruanganCol);

        table.setEditable(true);
        namaCol.setCellFactory(TextFieldTableCell.forTableColumn());
        mataKuliahCol.setCellFactory(TextFieldTableCell.forTableColumn());
        GKBlCol.setCellFactory(TextFieldTableCell.forTableColumn());
        waktuCol.setCellFactory(TextFieldTableCell.forTableColumn());
        ruanganCol.setCellFactory(TextFieldTableCell.forTableColumn());



        Button switchToFormButton = new Button("Back To Home");
        switchToFormButton.setPrefWidth(100);
        switchToFormButton.setOnAction(event -> {
            primaryStage.setScene(formScene);
            primaryStage.setTitle("Biodata Mahasiswa");
        });

        final Button Clearbutton = new Button("Clear");
        Clearbutton.setPrefWidth(100);
        Clearbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                table.getItems().removeAll(
                        table.getSelectionModel().getSelectedItems());
            }
        });

        final Button clearAllButton = new Button("Clear All");
        clearAllButton.setPrefWidth(100);
        clearAllButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!table.getItems().isEmpty()) {
                    ShowClearAlert();
                } else {
                    ItemTableIssNULL();
                }
            }
        });



        vbox.getChildren().addAll(label, table, switchToFormButton, Clearbutton, clearAllButton);
        return vbox;
    }

    private boolean validateInput() {
        boolean valid;
        String nama = addName.getText();
        String nim = addGKB.getText();
        String email = addMataKuliah.getText();
        String fakultas = addWaktu.getText();
        String jurusan = addRuangan.getText();
        if (nama.isEmpty() || nim.isEmpty() || email.isEmpty()|| fakultas.isEmpty()||jurusan.isEmpty()) {
            showEmptyFieldAlert();
            valid = false;
        }else {valid = true;
        }
        return valid;
    }

    private void showEmptyFieldAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Peringatan");
        alert.setHeaderText(null);
        alert.setContentText("Data tidak boleh ada yang kosong!");
        alert.showAndWait();
    }

    private void showEmailInvalid() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Peringatan");
        alert.setHeaderText(null);
        alert.setContentText("Email Yang Dimasukkan Tidak Valid!\nEmail harus berakhiran @webmail.umm.ac.id");
        alert.showAndWait();
    }
    private void showNIMInvalid() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Peringatan");
        alert.setHeaderText(null);
        alert.setContentText("NIM harus berupa angka!");
        alert.showAndWait();
    }

    private void ShowClearAlert() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Peringatan!");
        alert.setHeaderText(null);
        alert.setContentText("Apakah Anda Yakin Ingin Menghapus Semua Data?");

        ButtonType buttonTypeYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType buttonTypeNo = new ButtonType("No", ButtonBar.ButtonData.NO);

        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

        alert.showAndWait().ifPresent(buttonType -> {
            if (buttonType == buttonTypeYes) {
                table.getItems().clear();
            }
        });
    }

    private void ItemTableIssNULL() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informasi!");
        alert.setHeaderText(null);
        alert.setContentText("Data Dalam Table Kosong!");
        alert.showAndWait();
    }
    private void CreatItemDone() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informasi!");
        alert.setHeaderText(null);
        alert.setContentText("Berhasil Menambahkan Data");
        alert.showAndWait();
    }

}
