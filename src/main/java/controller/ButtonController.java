package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import model.product.CountingType;
import model.product.SingleProduct;
import sample.Main;

import javax.persistence.Table;
import java.awt.*;
import java.io.IOException;

public abstract class ButtonController  {



    public void initializeNewStage(Pane root, String resource, String windowTitle) {
        Pane pane = root;
        try {
            pane.getChildren().clear();
            FXMLLoader fxmlLoader = new FXMLLoader();
            pane.getChildren().add(fxmlLoader.load(getClass().getClassLoader().getResource(resource + ".fxml")));
            Main.getStage().setTitle(windowTitle);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addButtonClicked(TextField nazwa, TextField cena, Table table) {
        String name = nazwa.getText();
        Integer number = Integer.valueOf(cena.getText());
        CountingType countingType = changeCountingType();
        SingleProduct singleProduct = new SingleProduct(name,countingType,number);
       T.getItems().add(singleProduct);
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

}
