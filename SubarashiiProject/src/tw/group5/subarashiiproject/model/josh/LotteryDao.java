package tw.group5.subarashiiproject.model.josh;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class LotteryDao implements ILotteryDao {
	private Session session;

	public LotteryDao(Session session) {
		this.session = session;
	}
	
	@Override
	//insert
	public Lottery1 insert(Lottery1 lottery) {
		Lottery1 resultBean = session.get(Lottery1.class, lottery.getLotteryid());
		
		if(resultBean == null) {
			session.save(lottery);
			return lottery;
		}
		return null; //沒新增(已有資料)
	}
	
	@Override
	//selectAll
	public List<Lottery1> selectAll() {
		Query<Lottery1> query = session.createNamedQuery("from Lottery1", Lottery1.class);
		return query.list();
	}
	
	@Override
	//select(unique)
	public Lottery1 select(int lotteryid) {
		return session.get(Lottery1.class, lotteryid);
	}
	
	//update (lottery不太需要修改所以沒做)
	
	@Override
	//delete
	public boolean delete(int lotteryid) {
		Lottery1 resultBean = session.get(Lottery1.class, lotteryid);
		if(resultBean != null) {
			session.delete(resultBean);
			return true;
		}
		return false;
	}
	

}
