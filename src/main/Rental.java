package main;

public class Rental {
	private final Movie movie;
	private int daysRented;

	public Rental(Movie newmovie, int newdaysRented) {
		movie = newmovie;
		daysRented = newdaysRented;
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