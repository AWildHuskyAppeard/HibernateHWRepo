package tw.group5.subarashiiproject.action.josh;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.group5.subarashiiproject.model.josh.UsersService;
import tw.group5.subarashiiproject.util.HibernateUtil;

public class UsersActionEx1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean loginResult = false;
//		UsersActionEx1 action = new UsersActionEx1();
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			/*while (true) {
				if (args.length == 0) {
					System.out.println("請輸入帳號: ");
					String uname = sc.nextLine();
					System.out.println("請輸入密碼: ");
					String upsw = sc.nextLine();
					loginResult = processAction(uname, upsw, session);
					if (loginResult) {
						break;
					}
				}else {
					System.out.println("請輸入正確的帳號密碼!");
				}
			}*/
			
			
			Set<int[]> returnStuffs = playLottery();
			System.out.println("============back to main============");
			System.out.println("size: "+returnStuffs.size());
			Iterator<int[]> iter = returnStuffs.iterator();
			int[] num = null; //號碼
			int[] count = null; //出現次數
			while(iter.hasNext()) {
				num = iter.next();
				count = iter.next();
			}
			for(int i=0 ; i<6 ; i++) { //print出現前六多的號碼 & 出現次數
				System.out.println(num[i] + ":" + count[i] + "次");
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			
			HibernateUtil.closeSessionFactory();
		}
		

	}
	
	

	public static boolean processAction(String uname, String upsw, Session session) {

		boolean validity = false;
		
			UsersService usersService = new UsersService(session);
			validity = usersService.checkLoginAccess(uname, upsw);
			System.out.println((validity)? "Hello, " + uname+"!" : "登入失敗, 請再試一次!");
			
		return validity;
	}
	
	
	private static Set<int[]> playLottery() {
		LinkedHashSet returnStuffs = new LinkedHashSet();
		int showCount[] = new int[42]; //出現次數
		int num[] = new int[42];
		for (int i=1 ; i<100000 ; i++) {
			int randomNumer = (int)(Math.random()*42 +1); //randomNum接收亂數,把float轉成int
			showCount[randomNumer-1]++;
		}
		
		for(int i=0 ; i<num.length ; i++) {
			num[i]=i+1;
		}
		while (true) {
			int count = 0;
			for(int i=0 ; i<showCount.length-1 ; i++) {
				int countOrder = 0, numOrder = 0;
				if(showCount[i] < showCount[i+1]) {
					countOrder = showCount[i];
					showCount[i] = showCount[i+1];
					showCount[i+1] = countOrder;
					
					numOrder = num[i];
					num[i] = num[i+1];
					num[i+1] = numOrder;
					count++;
				}
				returnStuffs.add(num);
				returnStuffs.add(showCount);
			}
			if(count == 0) {
				break;
			}
		}
		return returnStuffs;
	}

	
	
	

}








