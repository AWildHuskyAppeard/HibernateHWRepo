package tw.group5.subarashiiproject.model.tajen;

import java.util.List;

public interface ILotteryDAO {
	public Lottery insert(Lottery newLottery);
	public Lottery[] inserts(Lottery[] newLotterys);
	public List<Lottery> selectMore(int rowNum);
	public Lottery select(int id);
}
