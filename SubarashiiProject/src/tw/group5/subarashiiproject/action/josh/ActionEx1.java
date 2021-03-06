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

import tw.group5.subarashiiproject.model.josh.Lottery1;
import tw.group5.subarashiiproject.model.josh.LotteryDao;
import tw.group5.subarashiiproject.model.josh.LotteryService;
import tw.group5.subarashiiproject.model.josh.UsersService;
import tw.group5.subarashiiproject.util.HibernateUtil;

public class ActionEx1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String hints = "\n輸入 playlottery 來產生一組亂數並存入資料庫，\n輸入 read 來讀取單筆統計資料，\n輸入 readall 來查看前六筆統計資料，\n輸入 break 來結束程式";
		boolean loginResult = false;
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			while (true) {
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
			}
			
			
			if(loginResult == true) { //登入成功: 做事
				boolean station = false;
				do {
					System.out.println(hints);
					Scanner scn = new Scanner(System.in);
					switch (scn.nextLine()) {
					case "playlottery":
						//執行亂數生成 & 統計
						Set<int[]> returnStuffs = playLottery();
//						System.out.println("============back to main============");
//						System.out.println("size: "+returnStuffs.size());
						Iterator<int[]> iter = returnStuffs.iterator();
						int[] num = null; //號碼
						int[] count = null; //出現次數
						while(iter.hasNext()) {
							num = iter.next();
							count = iter.next();
						}
						
						//test
						/*for(int i=0 ; i<6 ; i++) { //print出現前六多的號碼 & 出現次數
							System.out.println(num[i] + ":" + count[i] + "次");
						}*/
						
						insertLottery(num, count, session);
						break;
					case "read":
						System.out.println("請輸入要查詢的id (1~6)");
						int lotteryid = scn.nextInt();
						processReadUnique(lotteryid, session);
						//讀資料
						break;
					case "readall":
						processReadAll(session);
						break;
					case "break":
						station = true;
						break;
					default:
						scn.nextLine();
						System.out.println(hints);
						break;
					}
					
				} while (! station);
					System.out.println("程式結束!");
				
			}

			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			
			HibernateUtil.closeSessionFactory();
		}
	}
	
	

	private static void insertLottery(int[] num, int[] count, Session session) {
		for (int i=0 ; i<6 ; i++) {
			LotteryService lotteryService = new LotteryService(session);
			Lottery1 lottery1 = new Lottery1();
			lottery1.setNum(num[i]);
			lottery1.setTotalcnt(count[i]);
			lotteryService.insert(lottery1);
		}
			System.out.println("資料匯入成功!");
	}

	
	
	public static void processReadUnique(int lotteryid, Session session) {
		LotteryService lotteryService = new LotteryService(session);
		Lottery1 uniqueResult = lotteryService.select(lotteryid);
		if(uniqueResult != null) {
			System.out.println("號碼: " + uniqueResult.getNum() + "出現次數: " + uniqueResult.getTotalcnt());
		}else {
			System.out.println("沒有這筆資料，請輸入號碼 1~6 來查看");
		}
	}
	
	
	public static void processReadAll(Session session) {
		LotteryService lotteryService = new LotteryService(session);
		java.util.List<Lottery1> selectAllResult = lotteryService.selectAll();
		Iterator<Lottery1> it = selectAllResult.iterator();
		while(it.hasNext()) {
			Lottery1 lotterys = (Lottery1)it.next();
			System.out.println(lotterys.getNum() + ": 出現" + lotterys.getTotalcnt() + " 次");
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
		LinkedHashSet<int[]> returnStuffs = new LinkedHashSet<>();
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
