package com.example.modul6.Praktikum;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Praktikum1 extends Application {
    private TableView<Mahasiswa> table = new TableView<>();
    private TextField addName;
    private TextField addNIM;
    private TextField addEmail;
    private TextField addFakultas;
    private TextField addJurusan;
    private TextField addAlamat;
    private TextField addKota;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox formLayout = createFormLayout(primaryStage);
        Scene formScene = new Scene(formLayout, 500, 400);

        VBox tableLayout = createTableLayout(primaryStage, formScene);
        Scene tableScene = new Scene(tableLayout, 600, 400);

        primaryStage.setTitle("Form - Biodata Mahasiswa");
        primaryStage.setScene(formScene);
        primaryStage.show();

        Button switchToTableButton = new Button("Read");
        switchToTableButton.setPrefWidth(100);
        switchToTableButton.setOnAction(event -> {
            primaryStage.setScene(tableScene);
            primaryStage.setTitle("TableView - Biodata Mahasiswa");
        });

        Button addButton = new Button("Create");
        addButton.setPrefWidth(100);
        addButton.setOnAction(event -> {
            if (validateInput()) {
                Mahasiswa mahasiswa = new Mahasiswa(
                        addName.getText(),
                        addNIM.getText(),
                        addEmail.getText(),
                        addFakultas.getText(), addJurusan.getText(), addAlamat.getText(), addKota.getText());
                table.getItems().add(mahasiswa);
                addName.clear();
                addNIM.clear();
                addEmail.clear();
                addFakultas.clear();
                addJurusan.clear();
                addAlamat.clear();
                addKota.clear();
                CreatItemDone();
            } 
        });

        formLayout.getChildren().addAll(addButton, switchToTableButton);
    }

    private VBox createFormLayout(Stage primaryStage) {
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10, 10, 10, 10));

        Label label = new Label("Form Data Mahasiswa");
        label.setFont(new Font("Arial", 20));

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(5);

        Label Nama = new Label("Nama        :");
        Nama.setFont(new Font("Arial", 12));
        GridPane.setConstraints(Nama, 0, 0);

        Label NIM = new Label("NIM          :");
        NIM.setFont(new Font("Arial", 12));
        GridPane.setConstraints(NIM, 0, 1);

        Label Email = new Label("Email       :");
        Email.setFont(new Font("Arial", 12));
        GridPane.setConstraints(Email, 0, 2);

        Label Fakultas = new Label("Fakultas       :");
        Fakultas.setFont(new Font("Arial", 12));
        GridPane.setConstraints(Fakultas, 0, 3);

        Label Jurusan = new Label("Jurusan       :");
        Jurusan.setFont(new Font("Arial", 12));
        GridPane.setConstraints(Jurusan, 0, 4);

        Label Alamat = new Label("Alamat       :");
        Alamat.setFont(new Font("Arial", 12));
        GridPane.setConstraints(Alamat, 0, 5);

        Label Kota = new Label("Kota       :");
        Kota.setFont(new Font("Arial", 12));
        GridPane.setConstraints(Kota, 0, 6);

        addName = new TextField();
        addName.setPromptText("Nama Mahasiswa");

        addName.setPrefWidth(300);
        addName.setFont(Font.font(15));
        GridPane.setConstraints(addName, 1, 0);

        addNIM = new TextField();
        addNIM.setPromptText("NIM");
        addNIM.setPrefWidth(200);
        addNIM.setFont(Font.font(15));
        GridPane.setConstraints(addNIM, 1, 1);

        addEmail = new TextField();
        addEmail.setPromptText("@webmail.umm.ac.id");
        addEmail.setPrefWidth(300);
        addEmail.setFont(Font.font(15));
        GridPane.setConstraints(addEmail, 1, 2);

        addFakultas = new TextField();
        addFakultas.setPromptText("Fakultas");
        addFakultas.setPrefWidth(300);
        addFakultas.setFont(Font.font(15));
        GridPane.setConstraints(addFakultas, 1, 3);

        addJurusan = new TextField();
        addJurusan.setPromptText("Jurusan");
        addJurusan.setPrefWidth(300);
        addJurusan.setFont(Font.font(15));
        GridPane.setConstraints(addJurusan, 1, 4);

        addAlamat = new TextField();
        addAlamat.setPromptText("Alamat");
        addAlamat.setPrefWidth(300);
        addAlamat.setFont(Font.font(15));
        GridPane.setConstraints(addAlamat, 1, 5);

        addKota = new TextField();
        addKota.setPromptText("Kota");
        addKota.setPrefWidth(300);
        addKota.setFont(Font.font(15));
        GridPane.setConstraints(addKota, 1, 6);

        gridPane.getChildren().addAll(Nama, NIM, Email, Fakultas, Jurusan,Alamat,Kota,addName, addNIM, addEmail, addFakultas,addJurusan,addAlamat,addKota);
        vbox.getChildren().addAll(label, gridPane);

        return vbox;
    }

    private VBox createTableLayout(Stage primaryStage, Scene formScene) {
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10, 10, 10, 10));

        Label label = new Label("Daftar Mahasiswa");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        final ObservableList<Mahasiswa> data = FXCollections.observableArrayList();
        TableColumn<Mahasiswa, String> namaCol = new TableColumn<>("Nama");
        TableColumn<Mahasiswa, String> nimCol = new TableColumn<>("NIM");
        TableColumn<Mahasiswa, String> emailCol = new TableColumn<>("Email");
        TableColumn<Mahasiswa, String> fakultasCol = new TableColumn<>("Fakultas");
        TableColumn<Mahasiswa, String> jurusanCol = new TableColumn<>("Jurusan");
        TableColumn<Mahasiswa, String> alamatCol = new TableColumn<>("Alamat");
        TableColumn<Mahasiswa, String> kotaCol = new TableColumn<>("Kota");

        namaCol.setCellValueFactory(new PropertyValueFactory<>("nama"));
        nimCol.setCellValueFactory(new PropertyValueFactory<>("NIM"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        fakultasCol.setCellValueFactory(new PropertyValueFactory<>("fakultas"));
        jurusanCol.setCellValueFactory(new PropertyValueFactory<>("jurusan"));
        alamatCol.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        kotaCol.setCellValueFactory(new PropertyValueFactory<>("kota"));
        table.setItems(data);

        table.getColumns().addAll(namaCol, nimCol, emailCol, fakultasCol,alamatCol,kotaCol);

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
        String nim = addNIM.getText();
        String email = addEmail.getText();
        String fakultas = addFakultas.getText();
        String jurusan = addJurusan.getText();
        String alamat = addAlamat.getText();
        String kota = addKota.getText();
        if (nama.isEmpty() || nim.isEmpty() || email.isEmpty()|| fakultas.isEmpty()||jurusan.isEmpty()||alamat.isEmpty()||kota.isEmpty()) {
            showEmptyFieldAlert();
            valid = false;
        }else if (!NIMVerification(nim)){
            NIMIsnotValid();
            valid = false;
        } else if (!emailVerification(email)) {
            showEmailInvalid();
            valid = false;
        }else {valid = true;}
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
    private static boolean emailVerification(String email){
        String regexEmail = "^[a-zA-Z0-9._]+@webmail.umm.ac.id$";

        Pattern pattern = Pattern.compile(regexEmail);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    private void NIMIsnotValid() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informasi!");
        alert.setHeaderText(null);
        alert.setContentText("NIM Tidak Valid!");
        alert.showAndWait();
    }

    private static boolean NIMVerification(String Nim){
        return Nim.matches("\\d+");
    }

}
