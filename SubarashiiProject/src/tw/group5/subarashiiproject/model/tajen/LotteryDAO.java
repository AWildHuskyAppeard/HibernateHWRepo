package tw.group5.subarashiiproject.model.tajen;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class LotteryDAO {
	
	private Session session;
	
	public LotteryDAO(Session session) {
		this.session = session;
	}
	
	public Lottery insert(Lottery newLottery) {
//		Lottery resultBean = session.get(Lottery.class, newLottery.getId());
//		
//		if(resultBean == null) {
			this.session.save(newLottery);
			return newLottery;
//		} else {
//			return null;
//		}	
	}
	
	public Lottery[] inserts(Lottery[] newLotterys) {
		
		for (int i = 0; i < newLotterys.length; i++) {
			this.session.save(newLotterys[i]);
		}
		return newLotterys;
	}
	
	public List<Lottery> selectAll() {
		Query<Lottery> query = this.session.createQuery("FROM Lottery", Lottery.class);
		return query.list();
	}
	
	public Lottery select(int id) {
		return this.session.get(Lottery.class, id);
	}
}
