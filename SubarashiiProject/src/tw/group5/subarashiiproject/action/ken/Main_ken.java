package tw.group5.subarashiiproject.action.ken;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import tw.group5.subarashiiproject.model.ken.Lottery_Bean_ken;
import tw.group5.subarashiiproject.model.ken.UserBean_ken;
import tw.group5.subarashiiproject.model.ken.UsersService_ken;
import tw.group5.subarashiiproject.util.HibernateUtil;

public class Main_ken {

	public static void main(String[] args) {
		// for typing in
		Scanner input = new Scanner(System.in);

		outer: while (true) {

			System.out.println("請輸入數字 1.登入   2.註冊帳號 或輸入任意鍵離開");
			// get choice
			String choice = input.next();
			try {

				if ("1".equals(choice)) {
					Main_ken main_ken = new Main_ken();
					boolean check = main_ken.processCheckLog();
					System.out.println("歡迎來到樂透號碼產生器");

					// 登入成功 選擇接下來要做的動作
					while (check == true) {

						System.out.println("請輸入要產生幾組樂透號碼:");
						main_ken.lottery();

						System.out.println("輸入0結束程式顯示所有資料或任意數字鍵繼續");

						if (main_ken.close() == true) {
							SessionFactory factory = HibernateUtil.getSessionFactory();
							Session session = factory.getCurrentSession();

							try {
								session.beginTransaction();

								Query<Lottery_Bean_ken> query = session.createQuery("from Lottery_Bean_ken",
										Lottery_Bean_ken.class);

								List<Lottery_Bean_ken> list = query.list();

								Iterator<Lottery_Bean_ken> i1 = list.iterator();

								while (i1.hasNext()) {
									Lottery_Bean_ken lottery_Bean_ken = (Lottery_Bean_ken) i1.next();
									System.out.println(lottery_Bean_ken);

								}

								session.getTransaction().commit();
							} catch (Exception e) {
								session.getTransaction().rollback();
								System.err.println("抱歉數據有問題請重新操作");
								break outer;
							}

							break outer;
						}

					}

				} else if ("2".equals(choice)) {
					// 取得註冊帳密
					Main_ken main_ken = new Main_ken();

					main_ken.proccesInsert();
				} else {
					break outer;
				}

			} catch (Exception e) {
				System.out.println("輸入錯誤請重新輸入");

				break outer;
			}
		}

		System.out.println("Bye Bye~");
		HibernateUtil.closeSessionFactory();
	}

	public boolean close() {
		Scanner input = new Scanner(System.in);

		int num = input.nextInt();

		try {
			if (num != 0) {
				return false;
			}

		} catch (Exception e) {
			System.out.println("請重新輸入");
		}

		return true;
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
				} else if (check == false) {

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

	public boolean processCheckLog() {
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
				return true;
			} else {
				session.getTransaction().rollback();
				System.out.println("帳號密碼不符合 請重新輸入");
			}

		} catch (Exception e) {

			session.getTransaction().rollback();
			e.printStackTrace();
		}
		HibernateUtil.closeSessionFactory();
		return false;
	}

	public void lottery() {

		Scanner input = new Scanner(System.in);

		try {
			int num = input.nextInt();

			for (int j = 0; j < num; j++) {

				int[] count = new int[42];
				int[] lottery = new int[42];

				for (int i = 0; i < 10000; i++) {
					int temp = (int) (Math.random() * 42 + 1);
					count[temp - 1]++;
				}

				for (int i = 0; i < lottery.length; i++) {
					lottery[i] = i + 1;

				}
				while (true) {
					int a = 0;

					for (int i = 0; i < count.length - 1; i++) {
						if (count[i] < count[i + 1]) {
							int temp, temp2;
							// 前後排序
							temp = count[i];
							count[i] = count[i + 1];
							count[i + 1] = temp;

							// 號碼排序
							temp2 = lottery[i];
							lottery[i] = lottery[i + 1];
							lottery[i + 1] = temp2;

							a++;
						}
					}

					if (a == 0) {

						SessionFactory factory = HibernateUtil.getSessionFactory();
						Session session = factory.getCurrentSession();

						try {
							session.beginTransaction();

							Lottery_Bean_ken lotteryBean = new Lottery_Bean_ken();
							lotteryBean.setNo_1(lottery[0]);
							lotteryBean.setNo_2(lottery[1]);
							lotteryBean.setNo_3(lottery[2]);
							lotteryBean.setNo_4(lottery[3]);
							lotteryBean.setNo_5(lottery[4]);
							lotteryBean.setNo_6(lottery[5]);

//							LotteryService_ken lotteryService = new LotteryService_ken(session);
//							
//							lotteryService.insertLottery(lotteryBean);
							session.save(lotteryBean);

							session.getTransaction().commit();
							System.out.println("已儲存此次樂透號碼");

						} catch (Exception e) {
							session.getTransaction().rollback();
							System.out.println("儲存失敗");
							e.printStackTrace();
						}

//						System.out.print("第" + (j + 1) + "組號碼:");
//						for (int i = 0; i < 6; i++) {
//							System.out.print(lottery[i] + " ");
//						}

						System.out.println();

						break;
					}
				}

			}
		} catch (Exception e) {
			System.out.println("輸入錯誤情重新輸入");
		}
	}

}
