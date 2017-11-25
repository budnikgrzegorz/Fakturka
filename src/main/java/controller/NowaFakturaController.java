package controller;

import contractor.Adress;
import contractor.Role;
import contractor.SingleContractor;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.invoice.InvoiceType;
import model.invoice.PaymentMethod;
import model.invoice.SingleInvoice;
import model.product.SingleProduct;
import sample.Main;

import javax.swing.table.TableColumn;
import javax.swing.text.TableView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class NowaFakturaController {


    @FXML
    TextField numerfaktury;

    @FXML
    TextField dataystawienia;

    @FXML
    TextField datasprzedazy;

    @FXML
    TextField nabywca;

    @FXML
    Button buttonNabywca;

    @FXML
    TextField platnik;

    @FXML
    Button buttonPlatnik;

    @FXML
    MenuButton typplatnosci;

    @FXML
    TextField terminplatności;

    @FXML
    TextField dataplatnosci;

    @FXML
    TableView tableView;

    @FXML
    TableColumn lp;

    @FXML
    TableColumn numer;

    @FXML
    TableColumn dataSprzedazy;

    @FXML
    TableColumn dataPlatnosci;

    @FXML
    TableColumn columnNabywca;

    @FXML
    TableColumn columnPlatnik;

    @FXML
    TableColumn netto;

    @FXML
    TableColumn vat;

    @FXML
    TableColumn brutto;

    @FXML
    Button buttonSprzedaz;

    @FXML
    Button buttonWystawienie;

    @FXML
    MenuItem menufaktura;

    @FXML
    MenuItem menukorygujaca;

    @FXML
    MenuItem menuproforma;


    @FXML
    MenuButton typfaktury;

    @FXML
    MenuItem fakturaZaliczkowa;

    @FXML
    MenuItem fakturaRozliczeniowa;

    @FXML
    Button dodaj;

    @FXML
    AnchorPane pane;


    public String currentDateStr() {
        String currDate;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = new java.util.Date();
        currDate = dateFormat.format(date);
        return (currDate);
    }


    @FXML
    public void initialize() {

        dodaj.setOnAction(event -> {

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("Produkty.fxml"));
                Parent root1 = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Produkty");
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        menufaktura.setOnAction(event -> {
            Main.getStage().setTitle("Faktura Sprzedażowa");
            typfaktury.setText("Faktura Sprzedażowa");
        });

        menukorygujaca.setOnAction(event -> {
            Main.getStage().setTitle("Faktura Korygująca");
            typfaktury.setText("Faktura Korygująca");
        });

        menuproforma.setOnAction(event -> {
            Main.getStage().setTitle("Faktura Proforma");
            typfaktury.setText("Faktura Proforma");
        });

        fakturaZaliczkowa.setOnAction(event -> {
            Main.getStage().setTitle("Faktura Zaliczkowa");
            typfaktury.setText("Faktura Zaliczkowa");
        });

        fakturaRozliczeniowa.setOnAction(event -> {
            Main.getStage().setTitle("Faktura Rozliczeniowa");
            typfaktury.setText("Faktura Rozliczeniowa");
        });


        numerfaktury.setText("55");
        datasprzedazy.setText(currentDateStr());
        dataplatnosci.setText(currentDateStr());


    }

    private InvoiceType changeInvoiceType() {
        InvoiceType invoiceType = null;
        switch (typfaktury.getText()) {
            case "Faktura Sprzedażowa":
                return invoiceType = InvoiceType.FAKTURA_VAT;
            case "Faktura Korygująca":
                return invoiceType = InvoiceType.FAKTURA_KORYGUJACA;
            case "Faktura Proforma":
                return invoiceType = InvoiceType.FAKTURA_PROFORMA;
            case "Faktura Zaliczkowa":
                return invoiceType = InvoiceType.FAKTURA_ZALICZKOWA;
            case "Faktura Rozliczeniowa":
                return invoiceType = InvoiceType.FAKTURA_ZALICZKOWA;
        }
        return invoiceType;
    }

    private SingleInvoice createSingleInvoice() {
        InvoiceType invoiceType;
        SingleContractor buyer;
        SingleContractor payer;
        int dateOfPayment = Integer.parseInt(dataplatnosci.getText());
        int dayOfPayment = Integer.parseInt(datasprzedazy.getText());
        int accountNumber = Integer.parseInt(numerfaktury.getText());
        int invoiceNumber = Integer.parseInt(numerfaktury.getText());
        List<SingleProduct> singleProduct = null;
        PaymentMethod paymentMethod = null;

        invoiceType = changeInvoiceType();
        Adress adress = new Adress("Chorzowska 2", "Katowice", "40-860");
        buyer = new SingleContractor("Jacek", "Nowak", Role.DEALER, adress);
        Adress adress1 = new Adress("Katowicka 2 ", "Chorzow", "50-896");
        payer = new SingleContractor("Mietek", "Kowalski", Role.CONTRACTOR, adress1);
        SingleInvoice singleInvoice = new SingleInvoice(invoiceType, buyer, payer, dateOfPayment, dayOfPayment, accountNumber, invoiceNumber, singleProduct, paymentMethod);

        return singleInvoice;
    }
}