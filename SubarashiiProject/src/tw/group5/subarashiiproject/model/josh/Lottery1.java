package tw.group5.subarashiiproject.model.josh;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lottery")
public class Lottery1 {
	@Id
	@Column(name = "LOTTERYID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lotteryid;

	@Column(name = "NUM")
	private int num;

	@Column(name = "TOTALCNT")
	private int totalcnt;

	public int getLotteryid() {
		return lotteryid;
	}

	public void setLotteryid(int lotteryid) {
		this.lotteryid = lotteryid;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getTotalcnt() {
		return totalcnt;
	}

	public void setTotalcnt(int totalcnt) {
		this.totalcnt = totalcnt;
	}
}
