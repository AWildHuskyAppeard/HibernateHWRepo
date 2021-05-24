package tw.group5.subarashiiproject.action.yen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.group5.subarashiiproject.model.yen.LotteryService;
import tw.group5.subarashiiproject.model.yen.Lottery;
import tw.group5.subarashiiproject.util.HibernateUtil;

public class LotteryActionEx1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			int num = scanner.nextInt();
			Lottery lottery = lotteryAction(num);
			processInsertLottery(lottery, session);
			
			session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		HibernateUtil.closeSessionFactory();

	}

	private static void processInsertLottery(Lottery lottery, Session session) {
		
		LotteryService lotteryService = new LotteryService(session);
		lotteryService.insert(lottery);
		return;
		
	}

	private static Lottery lotteryAction(int num) {
		
		Lottery lottery = new Lottery();
		ArrayList a = new ArrayList();
		ArrayList b = new ArrayList();
		Integer[] c = new Integer[6];
		for(int i=0;i<100000;i++) {
			int lotnum = (int)Math.random()*42+1;
			a.add(lotnum);
		}
		for(int i=0;i<6;i++) {
			int maxnum = 1;
			int maxtotal = Collections.frequency(a, 1);
			for(int j=1;j<42;j++) {
				if(maxtotal<Collections.frequency(a, j+1)) {
					maxnum = j+1;
					maxtotal = Collections.frequency(a, j+1);
				}
			}
			b.add(maxnum);
			c[i] = maxnum;
			a.removeAll(b);
		}
		lottery.setNum01(c[0]);
		lottery.setNum01(c[1]);
		lottery.setNum01(c[2]);
		lottery.setNum01(c[3]);
		lottery.setNum01(c[4]);
		lottery.setNum01(c[5]);
		return lottery;
	}

}
