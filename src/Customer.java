import java.util.Date;


public class Customer {
	private String customerSocialGroup;

	
	public Customer(String customerSocialGroup) {
		this.customerSocialGroup = customerSocialGroup;
	}

	public String getCustomerSocialGroup() {
		return customerSocialGroup;
	}


	public void setCustomerSocialGroup(String customerSocialGroup) {
		this.customerSocialGroup = customerSocialGroup;
	}


	public Reservation createReservation(Customer customer, int trainNumber, Date reservationDate,
			int reservationPlace, String reservatinName){
		Reservation r = new Reservation(customer, trainNumber, reservationDate, reservationPlace, reservatinName);
		return r;
	}
	
	public Ticket createTicket(Reservation r){
		Ticket t = new Ticket(r);
		return t;
	}

}
