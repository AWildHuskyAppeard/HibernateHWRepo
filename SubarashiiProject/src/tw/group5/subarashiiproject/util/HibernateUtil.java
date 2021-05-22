package tw.group5.subarashiiproject.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
/**
 *@1. 一個專案(應用程式) = 一個cfg = 一個為一個sessionfactory 
 * 
 **/
public class HibernateUtil {
	private static final SessionFactory factory = createSessionFactory();

	private static SessionFactory createSessionFactory() {
		try {
			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
			SessionFactory factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
			return factory;
		} catch (Exception e) {
			 e.printStackTrace();
			 System.out.println("Failed to generate your SessionFactory sorry :(");
			 return null;	
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	
	public static void closeSessionFactory() {
		if (factory != null) {
			factory.close();
		}
	}
	
	
}