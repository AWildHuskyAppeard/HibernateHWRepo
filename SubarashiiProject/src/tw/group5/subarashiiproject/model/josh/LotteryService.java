package tw.group5.subarashiiproject.model.josh;

import java.util.List;

import org.hibernate.Session;

public class LotteryService {
	private LotteryDao lotteryDao;

	public LotteryService(Session session) {
		this.lotteryDao = new LotteryDao(session);
	}

	public Lottery1 insert(Lottery1 lottery) {
		return lotteryDao.insert(lottery);
	}
	
	public List<Lottery1> selectAll(){
		return lotteryDao.selectAll();
	}
	
	public Lottery1 select(int lotteryid) {
		return lotteryDao.select(lotteryid);
	}
	
	public boolean delete(int lotteryid) {
		return lotteryDao.delete(lotteryid);
	}
}
