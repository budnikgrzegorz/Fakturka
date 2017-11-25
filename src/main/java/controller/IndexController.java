package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class IndexController  extends ButtonController{

    @FXML
    MenuItem nowaFaktura;

    @FXML
    Pane pane;

    @FXML
    AnchorPane anchorPane;

    @FXML
    MenuItem wiecej;


    public void initialize() {

        nowaFaktura.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                initializeNewStage(pane,"NowaFaktura", "Nowa Faktura");
            }
        });

        wiecej.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                initializeNewStage(pane,"Ustawienia", "Ustawienia");
            }
        });
    }


    @Override
    public void initializeNewStage(Pane root, String resource, String windowTitle) {
        super.initializeNewStage(root, resource, windowTitle);
    }
}

