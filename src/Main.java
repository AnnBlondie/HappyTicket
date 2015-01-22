public class Main {

		public static void main(String[] args){
			
			DataBase db = new DataBase("postgres", "12345", "jdbc:postgresql://localhost:5432/HappyTickets");

            //DataBase db = new DataBase("postgres", "hermosa78", "jdbc:postgresql://localhost:5432/happyTickets" );
			
			ProcessController processController = new ProcessController(db);
			
			
			//UserData ud = new UserData();
			//ud.setVisible(true);

	}
}
