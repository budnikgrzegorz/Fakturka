package controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.product.CountingType;
import model.product.SingleProduct;

public class ProduktyController {


    @FXML
    private Button edytuj;

    @FXML
    private TableColumn<SingleProduct, CountingType> miara;

    @FXML
    private TableColumn<SingleProduct, Integer>  cena;

    @FXML
    private TableColumn<SingleProduct, String> nazwa;

    @FXML
    private TableView table;

    @FXML
    private Button usun;

    @FXML
    private TextField nazwaPole;

    @FXML
    private TextField cenaPole;

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
    private MenuButton liczenie;


    private static Stage stage;

    @FXML
    void initialize() {

nazwa.setCellValueFactory(new PropertyValueFactory<>("name"));
cena.setCellValueFactory(new PropertyValueFactory<>("number"));
miara.setCellValueFactory(new PropertyValueFactory<>("countingType"));

        this.stage = new Stage();
        kpt.setOnAction(event -> {
            liczenie.setText("kpt");
        });
        m.setOnAction(event -> {
            liczenie.setText("m2");
        });
        mb.setOnAction(event -> {
            liczenie.setText("mb");
        });
        szt.setOnAction(event -> {
            liczenie.setText("szt");
        });
        usl.setOnAction(event -> {
            liczenie.setText("usl");
        });

        dodaj.setOnAction(event -> {
addButtonClicked();

//            try {
//                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("));
//                Parent root1 = fxmlLoader.load();
//                stage.setTitle("Dodawanie produktu");
//                stage.setScene(new Scene(root1));
//                stage.show();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            ObservableList<SingleProduct> list = FXCollections.observableArrayList(
//                    new SingleProduct("dupa", CountingType.usl, 11));
//            table.setItems(list);
        });


    }



    private ObservableList addProduct() {
        ObservableList observableList = null;
        SingleProduct singleProduct = new SingleProduct(nazwaPole.getText(), changeCountingType(), Integer.parseInt(cenaPole.getText()));
        observableList.add(singleProduct);
        return observableList;

    }





    public static Stage getStage() {
        return stage;
    }

    public TableView<SingleProduct> getTable() {
        return table;
    }


}
