package edu.fatec.ipp002.strategy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.fatec.ipp002.strategy.model.ShoppingCart;
import edu.fatec.ipp002.strategy.paymentmethod.CreditCardPayment;
import edu.fatec.ipp002.strategy.paymentmethod.PixPayment;

@SpringBootApplication
public class PatternApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(PatternApplication.class, args);

		ShoppingCart cart = new ShoppingCart();

		cart.setPaymentStrategy(new CreditCardPayment());
		cart.checkout(100.0);

		cart.setPaymentStrategy(new PixPayment());
		cart.checkout(200.0);
	}

}
