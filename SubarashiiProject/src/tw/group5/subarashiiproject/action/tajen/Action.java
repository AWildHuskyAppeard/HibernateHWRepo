package tw.group5.subarashiiproject.action.tajen;
// PDF-1 TaJen

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.group5.subarashiiproject.model.tajen.Lottery;
import tw.group5.subarashiiproject.model.tajen.LotteryService;
import tw.group5.subarashiiproject.model.tajen.UsersService;
import tw.group5.subarashiiproject.util.HibernateUtil;
public class Action {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean validity = false;
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session cSession = factory.getCurrentSession();
		
		try {
			cSession.beginTransaction();
			/**************************************************/
		
				while (true) {
					if(args.length == 0) {
						// 1. Scanner輸入型
						// Q1. CMD的字串要加雙引號嗎？
						System.out.print("Account = ? ");
						String uname = scanner.nextLine();
						System.out.print("Password = ? ");
						String upsw = scanner.nextLine();
						validity = processLoginCheck(uname, upsw, cSession);
						if(validity) break;
						
						
					} else if(args.length == 2) {
						// 2. CMD呼叫方法時就先帶入好引數型
						validity = processLoginCheck(args[0], args[1], cSession);
						if (validity) break;
						System.out.println("Please try again.");
						return;
						
					} else {
						// 3. 亂來型
						System.out.println("Please enter account and password correctly!");
					}
				}
				System.out.print("Choose a number as lottery set: ");
				Integer lotterySet = scanner.nextInt();
				Lottery[] lotterys = playLottery(lotterySet);
				processInsertLottery(lotterys, cSession);

				
				
			/**************************************************/
			cSession.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			cSession.getTransaction().rollback();
			System.out.println("Rolling back...");
		} finally {
			
			HibernateUtil.closeSessionFactory();
		}
	}
	
	private static void processInsertLottery(Lottery[] lotterys, Session session) {
//		SessionFactory factory = HibernateUtil.getSessionFactory();
//		Session cSession = factory.getCurrentSession();
//		
//		try {
//			cSession.beginTransaction();
//			/**************************************************/
			
			LotteryService lotteryService = new LotteryService(session);
			lotteryService.inserts(lotterys);
//			System.out.println("blablabla");
			
//			/**************************************************/
//			cSession.getTransaction().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			cSession.getTransaction().rollback();
//		} finally {
//			
//			HibernateUtil.closeSessionFactory();
//		}
		return;
	}
		
	

	private static Lottery[] playLottery(int set) {
		
		Lottery[] lotterys = new Lottery[set];
		for (int k = 0; k < lotterys.length; k++) {
			
			Integer[] counter = new Integer[42];
			for (int i = 0; i < counter.length; i++) {
				counter[i] = 0;
			}
			for (int i = 0; i < 100000; i++) {
				Integer hit = (int)Math.ceil(Math.random()*42); // 1 ~ 42
				counter[hit - 1] += 1; // [0] ~ [41]
			}
			Integer[] topSix = new Integer[6];
			lotterys[k] = new Lottery();
			for (int i = 0; i < topSix.length; i++) {
				int max = 0;
				int maxIndex = -1;
				for (int j = 0; j < counter.length; j++) {
					if (counter[j] >= max) {
						max = counter[j];
						maxIndex = j;
					}
				}
				topSix[i] = maxIndex;
				lotterys[k].set(maxIndex  + 1);
				counter[maxIndex] = -1;
			}
			
		}
			return lotterys;
	}

	public static boolean processLoginCheck(String uname, String upsw, Session session) {
		
		boolean validity = false;
		
//		SessionFactory factory = HibernateUtil.getSessionFactory();
//		Session cSession = factory.getCurrentSession();
//		
//		try {
//			cSession.beginTransaction();
//			/**************************************************/
			
			UsersService usersService = new UsersService(session);
			validity = usersService.checkLoginAccess(uname, upsw);
			System.out.println((validity)? "Welcome back, " + uname + "." : "Greetings, stranger.");
			
//			/**************************************************/
//			cSession.getTransaction().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			cSession.getTransaction().rollback();
//		} finally {
//			
//			HibernateUtil.closeSessionFactory();
//		}
		return validity;
	}
}
