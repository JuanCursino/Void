package edu.fatec.ipp002.strategy.paymentmethod;

public class PixPayment extends PaymentStrategy
{
    @Override
    public void pay(double amount)
    {
        System.out.println("Paid R$ " + amount + " using Pix.");
    }
}
