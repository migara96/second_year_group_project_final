package lk.cmb.ucsc.drivingschool.model;


import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Payment{

    private String id;
    private String Student_name;
    private String Invoice_ID;
    private Integer Amount;
   // private Integer total_paid = Amount + getAmount();
    //private Integer fee = 15000;
    //private Integer balance = fee - total_paid;
    private Date Date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudent_name() {
        return Student_name;
    }

    public void setStudent_name(String student_name) {
        Student_name = student_name;
    }

    public String getInvoice_ID() {
        return Invoice_ID;
    }

    public void setInvoice_ID(String invoice_ID) {
        Invoice_ID = invoice_ID;
    }

    public Integer getAmount() {
        return Amount;
    }

    public void setAmount(Integer amount) {
        Amount = amount;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }
}
