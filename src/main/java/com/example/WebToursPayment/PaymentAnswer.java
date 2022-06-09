package com.example.WebToursPayment;

public class PaymentAnswer {

    public final long receiptId;
    public final String status;

    public PaymentAnswer(long receiptId, String status) {
        this.receiptId = receiptId;
        this.status = status;
    }

    private long getId() {
        return receiptId;
    }

    private String getContent() {
        return status;
    }

   @Override
   public String toString() {
        return "{" + receiptId +
                ", " + status +
                '}';}
}