import java.awt.EventQueue;
/*
 * Каким образом можно организовать управление формами ГУИ через main? Пока получается что 
 * формы вызываются каскадно каждая следущая через actionListener предыдущей. Есть ли метод
 * их вызывать последовательно, учитывая что каждая следущая форма инициализируется 
 * результатами с предыдущей (сохранить результат в переменную класса через getSelectedItem() 
 * не получается)?
 * 
   Ответ такой - через каскадный actionListener не хорошо, но и через main тоже не правильно.
   А что бы сделать это правильно, вам нужно почитать про паттерн MVC. Если в двух словах, то
   смысл примерно такой - у вас есть несколько форм (views) и данные (models). Формы не должны
   зависисть одна от другой (в общем случае). А что бы сделать эту связь, должен быть некий
   класс контроллер - ог должен связывать данные и формы. Т.е. в вашем случае - контроллер
   запускает (инициализирует данными) одну форму, полчает результат её работы. В зависимости
   от результатов - запускает следующую и т.д.
   
 * Нужно ли в каждом методе класса работы с базой данных DataBase проводить подключение и 
 * отключение базы, или можно оставить в таком виде (связь открывается конструктором, в конце
 * вызывается метод закрытия связи close())?
 
   В каждом методе - точно не надо, это не правильно. Открытие соединения - это дорогая в плане
   времени операция, если клиентов будет одновременно 100 - сайт перестанет рабтать :). Делать
   это в конструкторе тоже не очень, хотя и лучше. В идеале должен быть пул подключений (паттерн),
   в простом варианте можно сделать отдельный методы типа dbConnect/dbDisconnect и вызывать их
   отдельно (не в конструкторах)
 
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
