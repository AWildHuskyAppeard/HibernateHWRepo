package tw.group5.subarashiiproject.model.ken;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class Lottery_Dao_ken implements ILottery_Dao_ken {
	
	private Session session;

	public Lottery_Dao_ken(Session session) {
		this.session = session;
	}

	@Override
	public boolean insertLottery(Lottery_Bean_ken lottery) {
		
		Lottery_Bean_ken resultBean = session.get(Lottery_Bean_ken.class, lottery.getId());
		
		if (resultBean == null) {
			session.save(lottery);
			return true;
		}
		
		return false;
	}

	@Override
	public List<Lottery_Bean_ken> selectAll() {
		
		Query<Lottery_Bean_ken> query = session.createQuery("from lottery", Lottery_Bean_ken.class);
		return query.list();
	}

}
