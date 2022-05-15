package test;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import main.Customer;
import main.Movie;
import main.Rental;

public class TestMain {

	@Before
	public void before() {
		Movie movie1 = new Movie("movie1", 1);
		Movie movie2 = new Movie("movie2", 2);
		Rental rental1 = new Rental(movie1, 10);
		Rental rental2 = new Rental(movie2, 5);
		Customer customer1 = new Customer("joe");
		customer1.addRental(rental1);
		customer1.addRental(rental2);
	}
	@Test
	public void testCustomerReceipt() {
	}
	
	@Test
	public void testCustomerPrice() {
	}
	
	/*
	 * Other classes only contain constructors, getters and setters
	 */
}
