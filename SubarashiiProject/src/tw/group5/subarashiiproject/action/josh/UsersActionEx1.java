package tw.group5.subarashiiproject.action.josh;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.group5.subarashiiproject.model.josh.UsersService;
import tw.group5.subarashiiproject.util.HibernateUtil;

public class UsersActionEx1 {

	public static void main(String[] args) {
		UsersActionEx1 action = new UsersActionEx1();
		boolean loginResult = action.processAction();
		action.switchCase();

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
	
	int showCount[] = new int[42]; //出現次數
	int num[] = new int[42];
	
	public void count() {
		for (int i=1 ; i<100000 ; i++) {
			int randomNumer = (int)(Math.random()*42 +1); //randomNum接收亂數,把float轉成int
			showCount[randomNumer-1]++;
		}
	}
	
	public void sortarray() { //排序出現次數(大到小)
		
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
			}
			if(count == 0) {
				break;
			}
		}
		
		for(int i=0 ; i<=6 ; i++) {
			System.out.println(num[i] + ":\t" + showCount[i] + "次");
		}
	}
	
	public void switchCase() {
		Scanner sc = new Scanner(System.in);
		String input1 = sc.nextLine();
		switch (input1) {
		case "lottery":
			System.out.println("Lottery");
			UsersActionEx1 action1 = new UsersActionEx1();
			action1.count();
			action1.sortarray();
			break;
		case "test":
			System.out.println("test!");
			break;
		
		default:
			break;
		}
		System.out.println("程式結束");
	}
	

}








