package tw.group5.subarashiiproject.util;

import java.util.ArrayList;

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
	
	/**
     * @SubMethod 萃取數字
     * @抄自Stackoverflow https://reurl.cc/qm7Z8q
     * @Example public static void main(String[] args) {
	 *			    String input = "0-123-abc-456-xyz-789";
	 *			    String result = stripNonDigits(input);
	 *			    System.out.println(result);
	 *			}
	 * @補充 Integar.parseInt("00077")的結果會跑出77
     **/
    public static String stripNonDigits(CharSequence input){
	    StringBuilder sb = new StringBuilder(input.length());
	    for(int i = 0; i < input.length(); i++){
	        char c = input.charAt(i);
	        if(c > 47 && c < 58) {
	            sb.append(c);
	        }
	    }
	    return sb.toString();
    }
	/**
     * @SubMethod 取最大值
     **/
    public static int maxNum(ArrayList<Integer> intArrayList) {
    	// clone()前後ArrayList記憶體位置會不一樣、不會互相影響
		ArrayList<Integer> cloned = (ArrayList<Integer>)intArrayList.clone();
    	while (cloned.size() > 1) {
    		if(cloned.get(0) >= cloned.get(1)) {
    			cloned.remove(1);
    		} else {
				cloned.remove(0);
			}
		}
		int maxNum = cloned.get(0);
    	return maxNum;
    }
	
	
}
