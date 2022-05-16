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
		String result = "Rental Record for " + this.getName() + "\n";
		result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";
		Enumeration<Rental> enum_rentals = rentals.elements();

		while (enum_rentals.hasMoreElements()) {
			double thisAmount = 0;
			Rental each = (Rental) enum_rentals.nextElement();
			// determine amounts for each line
			thisAmount = each.price();
			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + "\t" + each.getDaysRented() + "\t"
					+ String.valueOf(thisAmount) + "\n";
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(getTotalPrice()) + "\n";
		result += "You earned " + String.valueOf(getFrequentREnterPoints()) + " frequent renter points";
		return result;
	}
	
	private double getTotalPrice() {
		double totalAmount = 0;
		Enumeration<Rental> enum_rentals = rentals.elements();
		
		while (enum_rentals.hasMoreElements()) {
			double thisAmount = 0;
			Rental each = (Rental) enum_rentals.nextElement();
			// determine amounts for each line
			thisAmount = each.price();
			// add frequent renter points
			totalAmount =+ thisAmount;
			
		}
		return totalAmount;
	}
	
	private int getFrequentREnterPoints() {
		Enumeration<Rental> enum_rentals = rentals.elements();
		int frequentRenterPoints = 0;
		while (enum_rentals.hasMoreElements()) {
			Rental each = (Rental) enum_rentals.nextElement();
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
				frequentRenterPoints++;
		}
		return frequentRenterPoints;
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
