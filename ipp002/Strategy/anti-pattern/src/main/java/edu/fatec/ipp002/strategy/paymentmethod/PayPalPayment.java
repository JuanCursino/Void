package edu.fatec.ipp002.strategy.paymentmethod;

public class PayPalPayment extends PaymentStrategy
{
    @Override
    public void pay(double amount)
    {
        System.out.println("Paid $ " + amount + " using PayPal.");
    }
}
