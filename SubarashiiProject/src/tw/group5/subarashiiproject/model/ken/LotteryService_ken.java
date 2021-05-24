package tw.group5.subarashiiproject.model.ken;

import java.util.List;

import org.hibernate.Session;

public class LotteryService_ken implements ILotteryService_ken {
	
	private Lottery_Dao_ken lottery_Dao_ken;

	public LotteryService_ken(Session session) {
		lottery_Dao_ken = new Lottery_Dao_ken(session);
	}

	@Override
	public boolean insertLottery(Lottery_Bean_ken lottery) {

		return lottery_Dao_ken.insertLottery(lottery);
	}

	@Override
	public List<Lottery_Bean_ken> selectAll() {

		return lottery_Dao_ken.selectAll();
	}

}
