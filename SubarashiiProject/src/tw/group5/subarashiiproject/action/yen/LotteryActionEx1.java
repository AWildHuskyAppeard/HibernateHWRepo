package tw.group5.subarashiiproject.action.yen;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.group5.subarashiiproject.util.HibernateUtil;

public class LotteryActionEx1 {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			
			
			session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		HibernateUtil.closeSessionFactory();

	}

}
