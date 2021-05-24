package tw.group5.subarashiiproject.model.ken;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lottery")
public class Lottery_Bean_ken {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "no_1")
	private int no_1;
	@Column(name = "no_2")
	private int no_2;
	@Column(name = "no_3")
	private int no_3;
	@Column(name = "no_4")
	private int no_4;
	@Column(name = "no_5")
	private int no_5;
	@Column(name = "no_6")
	private int no_6;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNo_1() {
		return no_1;
	}

	public void setNo_1(int no_1) {
		this.no_1 = no_1;
	}

	public int getNo_2() {
		return no_2;
	}

	public void setNo_2(int no_2) {
		this.no_2 = no_2;
	}

	public int getNo_3() {
		return no_3;
	}

	public void setNo_3(int no_3) {
		this.no_3 = no_3;
	}

	public int getNo_4() {
		return no_4;
	}

	public void setNo_4(int no_4) {
		this.no_4 = no_4;
	}

	public int getNo_5() {
		return no_5;
	}

	public void setNo_5(int no_5) {
		this.no_5 = no_5;
	}

	public int getNo_6() {
		return no_6;
	}

	public void setNo_6(int no_6) {
		this.no_6 = no_6;
	}

	@Override
	public String toString() {
		return "Lottery_Bean_ken [id=" + id + ", no_1=" + no_1 + ", no_2=" + no_2 + ", no_3=" + no_3 + ", no_4=" + no_4
				+ ", no_5=" + no_5 + ", no_6=" + no_6 + "]";
	}
	
	

}
