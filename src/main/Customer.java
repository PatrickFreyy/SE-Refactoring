package main;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	private String name;
	private Vector<Rental> rentals = new Vector<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		rentals.addElement(rental);
	}

	public String getName() {
		return name;
	}

	public String receipt() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration<Rental> enum_rentals = rentals.elements();
		String result = "Rental Record for " + this.getName() + "\n";
		result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

		while (enum_rentals.hasMoreElements()) {
			double thisAmount = 0;
			Rental each = (Rental) enum_rentals.nextElement();
			// determine amounts for each line
			thisAmount = each.price();
			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
				frequentRenterPoints++;
			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + "\t" + each.getDaysRented() + "\t"
					+ String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return result;
	}


	public Vector<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(Vector<Rental> rentals) {
		this.rentals = rentals;
	}

	public void setName(String name) {
		this.name = name;
	}
}
