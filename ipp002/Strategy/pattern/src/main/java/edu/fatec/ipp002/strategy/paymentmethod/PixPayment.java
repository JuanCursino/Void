package edu.fatec.ipp002.strategy.paymentmethod;

public class PixPayment implements PaymentStrategy
{
    public void pay(double amount)
    {
        System.out.println("Paid R$ " + amount + " using Pix.");
    }
}
