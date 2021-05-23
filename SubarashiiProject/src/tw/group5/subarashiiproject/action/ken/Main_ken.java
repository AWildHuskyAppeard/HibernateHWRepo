package tw.group5.subarashiiproject.action.ken;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.group5.subarashiiproject.model.ken.UserBean_ken;
import tw.group5.subarashiiproject.model.ken.UsersService_ken;
import tw.group5.subarashiiproject.util.HibernateUtil;

public class Main_ken {

	public static void main(String[] args) {
		// for typing in
		Scanner input = new Scanner(System.in);

		while (true) {

			System.out.println("請輸入數字 1.登入   2.註冊帳號");
			// get choice
			int choice = input.nextInt();

			try {

				if (choice == 1) {
					// 選擇接下來要做的動作
					Main_ken main_ken = new Main_ken();
					main_ken.processCheckLog();
					

				} else if (choice == 2) {
					// 取得註冊帳密
					Main_ken main_ken = new Main_ken();
					
					main_ken.proccesInsert();

				}
			} catch (InputMismatchException e) {
				System.out.println("輸入錯誤請重新輸入");
				continue;
			}
		}

	}

	private void proccesInsert() {
		// for typing in
		Scanner input = new Scanner(System.in);
		// setting session container
		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.getCurrentSession();

		// 取得註冊帳密
		System.out.println("請輸入註冊帳號:");
		String ac = input.next();

		System.out.println("請輸入註冊密碼:");
		String pwd = input.next();

		if (ac != null && pwd != null) {

			try {
				session.beginTransaction();

				UsersService_ken usersService = new UsersService_ken(session);

				UserBean_ken uBean = new UserBean_ken();

				uBean.setUserAC(ac);
				uBean.setUserPwd(pwd);

				boolean check = usersService.insertNewUser(uBean);
				
				if (check != false) {
					
					session.getTransaction().commit();
				}else {
					
					session.getTransaction().rollback();
					System.out.println("帳號已存在 請重新輸入");
				}

			} catch (Exception e) {
				session.getTransaction().rollback();
				e.printStackTrace();

			}
		}
		
		HibernateUtil.closeSessionFactory();

	}
	
	public void processCheckLog() {
				// for typing in
				Scanner input = new Scanner(System.in);
				// setting session container
				SessionFactory factory = HibernateUtil.getSessionFactory();

				Session session = factory.getCurrentSession();

				// 取得註冊帳密
				System.out.println("請輸入帳號:");
				String ac = input.next();

				System.out.println("請輸入密碼:");
				String pwd = input.next();
				
				try {
					session.beginTransaction();
					UsersService_ken uService = new UsersService_ken(session);
					
					boolean check = uService.checkLogInAccess(ac, pwd);
					
					if (check = true) {
						
						session.getTransaction().commit();
						System.out.println("登入成功");
					}else {
						session.getTransaction().rollback();
						System.out.println("帳號密碼不符合 請重新輸入");
					}
					
					
					
					
				} catch (Exception e) {

					session.getTransaction().rollback();
					e.printStackTrace();
				}
				HibernateUtil.closeSessionFactory();
				
	}

}
