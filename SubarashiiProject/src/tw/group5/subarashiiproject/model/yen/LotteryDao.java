package tw.group5.subarashiiproject.model.yen;

import org.hibernate.Session;

public class LotteryDao {
	
	private Session session;
	
	public LotteryDao(Session session) {
		this.session = session;
	}
	
	public Lottery insert(Lottery insertLottery) {
		this.session.save(insertLottery);
		return insertLottery;
	}
	
	public Lottery select(int lid) {
		return this.session.get(Lottery.class, lid);
	}

}
