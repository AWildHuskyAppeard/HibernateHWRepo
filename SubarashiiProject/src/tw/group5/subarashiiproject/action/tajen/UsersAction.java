package tw.group5.subarashiiproject.action.tajen;
// PDF-1 TaJen

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.group5.subarashiiproject.model.tajen.UsersService;
import tw.group5.subarashiiproject.util.HibernateUtil;
public class UsersAction {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean validity = false;
		while (true) {
			if(args.length == 0) {
				// 1. Scanner輸入型
				// Q1. CMD的字串要加雙引號嗎？
				System.out.print("Account = ? ");
				String uname = scanner.nextLine();
				System.out.print("Password = ? ");
				String upsw = scanner.nextLine();
				validity = processAction(uname, upsw);
				if(validity) break;
				
				
			} else if(args.length == 2) {
				// 2. CMD呼叫方法時就先帶入好引數型
				validity = processAction(args[0], args[1]);
				if (validity) break;
				System.out.println("Please try again.");
				return;
				
			} else {
				// 3. 亂來型
				System.out.println("Please enter account and password correctly!");
			}
		}
		
		playLottery(scanner);
	}
	
	private static void playLottery(Scanner scanner) {
		
		System.out.print("Choose a number as lottery set: ");
		Integer lotterySet = scanner.nextInt();
		
		Integer[] counter = new Integer[42];
		for (int i = 0; i < counter.length; i++) {
			counter[i] = 0;
		}
		for (int i = 0; i < 100000; i++) {
			Integer hit = (int)Math.ceil(Math.random()*42); // 1 ~ 42
			counter[hit - 1] += 1; // [0] ~ [41]
		}
	}

	public static boolean processAction(String uname, String upsw) {
		
		boolean validity = false;
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session cSession = factory.getCurrentSession();
		
		try {
			cSession.beginTransaction();
			/**************************************************/
			
			UsersService usersService = new UsersService(cSession);
			validity = usersService.checkLoginAccess(uname, upsw);
			System.out.println((validity)? "Welcome back, " + uname + "." : "Greetings, stranger.");
			
			/**************************************************/
			cSession.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			cSession.getTransaction().rollback();
		} finally {
			
			HibernateUtil.closeSessionFactory();
		}
		

		return validity;
	}
}
