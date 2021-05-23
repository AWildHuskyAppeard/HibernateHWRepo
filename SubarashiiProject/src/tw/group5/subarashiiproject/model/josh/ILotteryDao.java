package tw.group5.subarashiiproject.model.josh;

import java.util.List;

public interface ILotteryDao {
	
	public Lottery1 insert(Lottery1 lottery); //insert
	public List<Lottery1> selectAll(); //selectAll
	public Lottery1 select(int lotteryid); //selectUniqueItem
	public boolean delete(int lotteryid); //delete
	
}
