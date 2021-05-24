package tw.group5.subarashiiproject.model.yen;

import org.hibernate.Session;

public class LotteryService implements ILotteryService{
	
	private LotteryDao lotteryDao;
	
	public LotteryService(Session session) {
		this.lotteryDao = new LotteryDao(session);
	}

	@Override
	public Lottery insert(Lottery insertLottery) {
		return this.lotteryDao.insert(insertLottery);
	}

	@Override
	public Lottery select(int lid) {
		return this.lotteryDao.select(lid);
	}

}
