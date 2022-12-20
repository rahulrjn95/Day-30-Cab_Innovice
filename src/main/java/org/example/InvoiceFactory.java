package org.example;

public class InvoiceFactory {
    //Method for getting instance of invoice object
    public static IInvoice getInvoiceInstance(Invoice.TypeOfSubscription typeOfSubscription) {
        return new Invoice(typeOfSubscription);
    }
}
