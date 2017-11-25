package model.product;

import model.invoice.SingleInvoice;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class SingleProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private CountingType countingType;

    private int unitPrice;

    @ManyToMany
    private Set<SingleInvoice> invoices = new HashSet<>();

    public SingleProduct( String name, CountingType countingType, int unitPrice) {
               this.name = name;
        this.countingType = countingType;
        this.unitPrice = unitPrice;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CountingType getCountingType() {
        return countingType;
    }

    public void setCountingType(CountingType countingType) {
        this.countingType = countingType;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Set<SingleInvoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<SingleInvoice> invoices) {
        this.invoices = invoices;
    }


}
