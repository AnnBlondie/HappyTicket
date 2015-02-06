import java.util.ArrayList;

public class Train {
	private String trainNumber;
	private ArrayList<Wagon> wagons = new ArrayList<Wagon>();	
	
	public Train(String trainNumber){
		this.trainNumber=trainNumber;
	}
	 	
	public String getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}

	public ArrayList<Wagon> getWagons() {
		return wagons;
	}

	public void addWagon(String type, int number) {
		Wagon wagon = new Wagon(type, number);
		wagons.add(wagon);
	}
	
	public Wagon[] getWagonCurrentType(String type){
		ArrayList<Wagon> wagonsOfType = new ArrayList<Wagon>();
		for(Wagon w: wagons){
			if(w.getType().equals(type)){
				wagonsOfType.add(w);
			}
		}
		return (Wagon[]) wagonsOfType.toArray();
	}
	
	public class Wagon{
		private String type;
		private int number;
		private int[] freeSeats;
		
		Wagon(String type, int number){
			this.type=type;
			this.number=number;
		}
		
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		public int[] getFreeSeats() {
			return freeSeats;
		}
		public void setFreeSeats(int[] freeSeats) {
			this.freeSeats = freeSeats;
		}		
	}
}
