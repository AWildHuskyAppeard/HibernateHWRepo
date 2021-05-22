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
		
		if(args.length != 2) System.out.println("Please enter account and password correctly!");
		else {
//			processAction(uname, upsw);
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
