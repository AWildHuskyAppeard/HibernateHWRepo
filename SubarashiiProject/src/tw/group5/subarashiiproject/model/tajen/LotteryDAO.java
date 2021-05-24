package tw.group5.subarashiiproject.model.tajen;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class LotteryDAO implements ILotteryDAO {
	
	private Session session;
	
	public LotteryDAO(Session session) {
		this.session = session;
	}
	@Override
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
	@Override
	public Lottery[] inserts(Lottery[] newLotterys) {
		
		for (int i = 0; i < newLotterys.length; i++) {
			this.session.save(newLotterys[i]);
		}
		return newLotterys;
	}
	@Override
	public List<Lottery> selectMore(int rowNum) {
		Query<Lottery> query = this.session.createQuery("FROM Lottery ln ORDER BY ln.id DESC", Lottery.class).setMaxResults(rowNum);
		return query.list();
	}
	@Override
	public Lottery select(int id) {
		return this.session.get(Lottery.class, id);
	}
}
