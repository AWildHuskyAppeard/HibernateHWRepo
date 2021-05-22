package tw.group5.subarashiiproject.model.tajen;

import java.util.List;

import org.hibernate.Session;

public class LotteryService {
	private LotteryDAO lotteryDAO;
	
	public LotteryService(Session session) {
		this.lotteryDAO = new LotteryDAO(session);
	}
	
	public Lottery insert(Lottery newLottery) {
		return this.lotteryDAO.insert(newLottery);
	}
	
	public Lottery[] inserts(Lottery[] newLotterys) {
		
		return this.lotteryDAO.inserts(newLotterys);
	}
	
	public List<Lottery> selectAll() {
		return this.lotteryDAO.selectAll();
	}
	
	public Lottery select(int id) {
		return this.lotteryDAO.select(id);
	}
}
