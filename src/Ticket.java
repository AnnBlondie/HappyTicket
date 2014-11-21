
public class Ticket extends Reservation{
	private int ticketNumber = 0;
	
	public Ticket(Reservation r){
		super();
		System.out.println("Ticket's number="+ticketNumber);
		System.out.println(r.toString());
	}
	
	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public static void createPDFTicket(Reservation r){
		
	}

}
