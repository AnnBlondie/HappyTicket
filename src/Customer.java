import java.util.Date;


public class Customer {
    private String email;


    public Customer(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public Reservation createReservation(Customer customer, int trainNumber, Date reservationDate,
                                         int reservationPlace, String reservatinName) {
        Reservation r = new Reservation(customer, trainNumber, reservationDate, reservationPlace, reservatinName);
        return r;
    }

}
