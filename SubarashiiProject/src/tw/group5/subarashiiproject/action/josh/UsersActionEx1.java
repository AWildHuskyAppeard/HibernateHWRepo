package tw.group5.subarashiiproject.action.josh;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.group5.subarashiiproject.model.josh.UsersService;
import tw.group5.subarashiiproject.util.HibernateUtil;

public class UsersActionEx1 {

	public static void main(String[] args) {
		
		UsersActionEx1 action = new UsersActionEx1();
		action.processAction();
	}

	public boolean processAction() {
		
		System.out.println("請輸入帳號: ");
		Scanner scanner = new Scanner(System.in);
		String uname = scanner.nextLine();
		System.out.println("請輸入密碼: ");
		String upsw = scanner.nextLine();
		
		boolean validity = false;
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			UsersService usersService = new UsersService(session);
			validity = usersService.checkLoginAccess(uname, upsw);
			System.out.println((validity)? "Hello, " + uname+"!" : "登入失敗, 請再試一次!");
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			
			HibernateUtil.closeSessionFactory();
		}
		
		return validity;
	}
	
	

}
