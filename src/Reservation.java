import java.util.*;

public class Reservation extends Customer{
	
	private int trainNumber;
	private Date reservationDate;//include Time
	private int reservationPlace;
	private String reservatinName;
	private double ticketPrice;
	
	public Reservation() {
		super("");
		this.trainNumber = 0;
		this.reservationPlace = 0;
		this.reservatinName = "";
	}

	public Reservation(Customer customer, int trainNumber, Date reservationDate,
			int reservationPlace, String reservatinName) {
		super(customer.getEmail());
		this.trainNumber = trainNumber;
		this.reservationDate = reservationDate;
		this.reservationPlace = reservationPlace;
		this.reservatinName = reservatinName;
	}


	public int getTrainNumber() {
		return trainNumber;
	}


	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}


	public Date getReservationDate() {
		return reservationDate;
	}


	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}


	public int getReservationPlace() {
		return reservationPlace;
	}


	public void setReservationPlace(int reservationPlace) {
		this.reservationPlace = reservationPlace;
	}


	public String getReservatinName() {
		return reservatinName;
	}


	public void setReservatinName(String reservatinName) {
		this.reservatinName = reservatinName;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	@Override
	public String toString() {
		return "customerEmail="+super.getEmail()+" [reservatinName=" + reservatinName +
				", trainNumber=" + trainNumber + ", reservationDate="
				+ reservationDate.toString() + ", reservationPlace=" + reservationPlace
				+ ", ticketPrice="+ticketPrice+"]";
	}


	
	//public void sendEmail(Reservation r){
	//
	//}
}
