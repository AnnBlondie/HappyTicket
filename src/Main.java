import java.awt.EventQueue;
/*
 * Каким образом можно организовать управление формами ГУИ через main? Пока получается что 
 * формы вызываются каскадно каждая следущая через actionListener предыдущей. Есть ли метод
 * их вызывать последовательно, учитывая что каждая следущая форма инициализируется 
 * результатами с предыдущей (сохранить результат в переменную класса через getSelectedItem() 
 * не получается)?
 * 
 * Нужно ли в каждом методе класса работы с базой данных DataBase проводить подключение и 
 * отключение базы, или можно оставить в таком виде (связь открывается конструктором, в конце
 * вызывается метод закрытия связи close())?
 * 
 */


public class Main {

		public static void main(String[] args){
			//DataBase db = new DataBase("postgres", "12345", "jdbc:postgresql://localhost:5432/HappyTickets" );
			//db.selectAllTrains();
			//db.selectTrainFromTo("Львів","Одеса");
			//db.selectTrainFromTo("Київ Пасажирський","Харків");
			//db.closeDB();

				
            //1. first GUI - basic parameters search - from-to, date
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						SearchTrain window = new SearchTrain();
						window.setVisible(true);		
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		/*
			//2. second GUI - results of search and possibility to peek train
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						FoundRoutes window = new FoundRoutes();
						window.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
			
			//3. third GUI - wagon-seat proposition, price generation
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						SeatSelection window = new SeatSelection();
						window.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
			
			//4. fourth GUI - fulfilling passanger's personal data, creating reservation
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						VerificationTicket window = new VerificationTicket();
						window.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
			//5. e-mail input - sending reservation data to user 
            EventQueue.invokeLater(new Runnable() {
            	public void run() {
            		try {
            			UserData window = new UserData();
            			window.setVisible(true);
            		} catch (Exception e) {
            			e.printStackTrace();
            		}
            	}
            });
			

			*/
	}
}
