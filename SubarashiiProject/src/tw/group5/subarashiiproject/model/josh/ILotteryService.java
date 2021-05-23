package tw.group5.subarashiiproject.model.josh;

import java.util.List;

public interface ILotteryService {
	public Lottery1 insert(Lottery1 lottery);
	public List<Lottery1> selectAll();
	public Lottery1 select(int lotteryid);
	public boolean delete(int lotteryid);
}
