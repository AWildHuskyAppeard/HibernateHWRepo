package tw.group5.subarashiiproject.model.ken;

import java.util.List;

public interface ILotteryService_ken {
	public boolean insertLottery(Lottery_Bean_ken lottery);
	public List<Lottery_Bean_ken> selectAll();
}
