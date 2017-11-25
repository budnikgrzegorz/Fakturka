package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.product.CountingType;
import model.product.SingleProduct;

public class DodawanieProduktuController {


    @FXML
    private TextField cena;

    @FXML
    private Button dodaj;

    @FXML
    private MenuItem kpt;

    @FXML
    private MenuItem m;

    @FXML
    private MenuItem mb;

    @FXML
    private MenuItem szt;

    @FXML
    private MenuItem usl;

    @FXML
    private MenuButton miara;

    @FXML
    private TextField nazwaProduktu;



    @FXML
    private Button zamknij;

    private static Stage stage;

    @FXML
    public void initialize() {
        dodaj.setOnAction(event -> {
            createSingleProduct();
        });


        zamknij.setOnAction(event -> {
            ProduktyController.getStage().close();
        });
        kpt.setOnAction(event -> {
            miara.setText("kpt");
        });
        m.setOnAction(event -> {
            miara.setText("m2");
        });
        mb.setOnAction(event -> {
            miara.setText("mb");
        });
        szt.setOnAction(event -> {
            miara.setText("szt");
        });
        usl.setOnAction(event -> {
            miara.setText("usl");
        });
    }

    private CountingType changeCountingType() {
        CountingType countingType = null;
        switch (miara.getText()) {
            case "kpt":
                return countingType = CountingType.kpl;
            case "m2":
                return countingType = CountingType.m2;
            case "mb":
                return countingType = CountingType.mb;
            case "szt":
                return countingType = CountingType.szt;
            case "usl":
                return countingType = CountingType.usl;
        }
        return countingType;
    }


    private void createSingleProduct() {

        String name = nazwaProduktu.getText();
        CountingType countingType = changeCountingType();
        int pirce = Integer.parseInt(cena.getText());

        ProduktyController produktyController = null;
        ObservableList<SingleProduct> list = FXCollections.observableArrayList(
                new SingleProduct(name, countingType, pirce));


        produktyController.getTable().setItems(list);
        produktyController.initialize();

    }


}



