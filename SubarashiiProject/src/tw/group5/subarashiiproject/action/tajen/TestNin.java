package tw.group5.subarashiiproject.action.tajen;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.group5.subarashiiproject.model.tajen.UsersService;
import tw.group5.subarashiiproject.util.HibernateUtil;

public class TestNin {

	public static void main(String[] args) {
		System.out.println("0");
		HibernateUtil.getSessionFactory();
		System.out.println("1");
		HibernateUtil.closeSessionFactory();
		System.out.println("1");
		HibernateUtil.getSessionFactory();
		System.out.println("1");
		HibernateUtil.closeSessionFactory();
		
		
//		Integer[] a = new Integer[6];
//		for (int i = 0; i < a.length; i++) {
//			a[i] = 0;
//		}
//		System.out.println(a[3]);
		
//		SessionFactory factory = HibernateUtil.getSessionFactory();
//		Session cSession = factory.getCurrentSession();
//
//		cSession.beginTransaction();
//		
//		UsersService usersService = new UsersService(cSession);
//		boolean validity = usersService.checkLoginAccess("Okabe", "ahahahahaha");
//		System.out.println(validity);
//		
//		cSession.getTransaction().commit();
//		
//		
//		HibernateUtil.closeSessionFactory();
	}

}
