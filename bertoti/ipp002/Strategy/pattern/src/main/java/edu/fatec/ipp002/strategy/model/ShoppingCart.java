package edu.fatec.ipp002.strategy.model;

import edu.fatec.ipp002.strategy.paymentmethod.PaymentStrategy;

public class ShoppingCart
{
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy strategy)
    {
        this.paymentStrategy = strategy;
    }

    public void checkout(double amount)
    {
        if (paymentStrategy == null)
        {
            System.out.println("Payment method not selected!");
            return;
        }
        
        paymentStrategy.pay(amount);
    }
}
