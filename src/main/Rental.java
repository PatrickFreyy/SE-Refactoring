package main;

public class Rental {
	private final Movie movie;
	private int daysRented;

	public Rental(Movie newmovie, int newdaysRented) {
		movie = newmovie;
		daysRented = newdaysRented;
	}
	
	public double price() {
		double thisAmount = 0;
		switch (this.getMovie().getPriceCode()) {
		case Movie.REGULAR:
			thisAmount += 2;
			if (this.getDaysRented() > 2)
				thisAmount += (this.getDaysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			thisAmount += this.getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			thisAmount += 1.5;
			if (this.getDaysRented() > 3)
				thisAmount += (this.getDaysRented() - 3) * 1.5;
			break;
		}
		return thisAmount;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Movie getMovie() {
		return movie;
	}
	
	public void setDaysRented(int daysRented) {
		this.daysRented = daysRented;
	}
}