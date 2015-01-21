public class Main {

		public static void main(String[] args){
			
			DataBase db = new DataBase("postgres", "12345", "jdbc:postgresql://localhost:5432/HappyTickets");
			
			ProcessController processController = new ProcessController(db);
			
			//db.selectAllTrains();
			//db.selectTrainFromTo("Львів","Одеса");
			//db.selectTrainFromTo("Київ Пасажирський","Харків");

			//db.closeDB();

	}
}
