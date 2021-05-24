package tw.group5.subarashiiproject.model.tajen;

import java.util.List;

import org.hibernate.Session;

public class LotteryService implements ILotteryService {
	private LotteryDAO lotteryDAO;
	
	public LotteryService(Session session) {
		this.lotteryDAO = new LotteryDAO(session);
	}
	@Override
	public Lottery insert(Lottery newLottery) {
		return this.lotteryDAO.insert(newLottery);
	}
	@Override
	public Lottery[] inserts(Lottery[] newLotterys) {
		
		return this.lotteryDAO.inserts(newLotterys);
	}
	@Override
	public List<Lottery> selectMore(int setNum) {
		return this.lotteryDAO.selectMore(setNum);
	}
	@Override
	public Lottery select(int id) {
		return this.lotteryDAO.select(id);
	}
}
