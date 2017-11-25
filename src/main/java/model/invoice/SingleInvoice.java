package model.invoice;

import contractor.SingleContractor;


import model.product.SingleProduct;

import javax.persistence.*;
import java.util.List;

@Entity
public class SingleInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private InvoiceType invoiceType;

    private SingleContractor buyer;

    private SingleContractor payer;

    private int dateOfPayment;

    private int dayOfPayment;

    private int accountNumber;

    private int invoiceNumber;

    @ManyToMany(mappedBy = "SingleProduct")
    private List<SingleProduct> singleProduct;

    private PaymentMethod paymentMethod;

    public SingleInvoice(InvoiceType invoiceType, SingleContractor buyer, SingleContractor payer, int dateOfPayment, int dayOfPayment, int accountNumber, int invoiceNumber, List<SingleProduct> singleProduct, PaymentMethod paymentMethod) {
        this.invoiceType = invoiceType;
        this.buyer = buyer;
        this.payer = payer;
        this.dateOfPayment = dateOfPayment;
        this.dayOfPayment = dayOfPayment;
        this.accountNumber = accountNumber;
        this.invoiceNumber = invoiceNumber;
        this.singleProduct = singleProduct;
        this.paymentMethod = paymentMethod;
    }

    public InvoiceType getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(InvoiceType invoiceType) {
        this.invoiceType = invoiceType;
    }

    public SingleContractor getBuyer() {
        return buyer;
    }

    public void setBuyer(SingleContractor buyer) {
        this.buyer = buyer;
    }

    public SingleContractor getPayer() {
        return payer;
    }

    public void setPayer(SingleContractor payer) {
        this.payer = payer;
    }

    public int getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(int dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public int getDayOfPayment() {
        return dayOfPayment;
    }

    public void setDayOfPayment(int dayOfPayment) {
        this.dayOfPayment = dayOfPayment;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public List<SingleProduct> getSingleProduct() {
        return singleProduct;
    }

    public void setSingleProduct(List<SingleProduct> singleProduct) {
        this.singleProduct = singleProduct;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
