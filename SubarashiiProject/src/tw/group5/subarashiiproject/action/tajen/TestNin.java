package tw.group5.subarashiiproject.action.tajen;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.group5.subarashiiproject.model.tajen.UsersService;
import tw.group5.subarashiiproject.util.HibernateUtil;

public class TestNin {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session cSession = factory.getCurrentSession();

		cSession.beginTransaction();
		
		cSession.createQuery("");
		
		cSession.getTransaction().commit();
		
		
		HibernateUtil.closeSessionFactory();
	}

}
