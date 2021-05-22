package tw.group5.subarashiiproject.model.tajen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "Lottery")
@Table(name = "Lottery")
public class Lottery {
	@Id @Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "C01") private Integer c01 = 0;
	@Column(name = "C02") private Integer c02 = 0;
	@Column(name = "C03") private Integer c03 = 0;
	@Column(name = "C04") private Integer c04 = 0;
	@Column(name = "C05") private Integer c05 = 0;
	@Column(name = "C06") private Integer c06 = 0;
	@Column(name = "C07") private Integer c07 = 0;
	@Column(name = "C08") private Integer c08 = 0;
	@Column(name = "C09") private Integer c09 = 0;
	@Column(name = "C10") private Integer c10 = 0;
	@Column(name = "C11") private Integer c11 = 0;
	@Column(name = "C12") private Integer c12 = 0;
	@Column(name = "C13") private Integer c13 = 0;
	@Column(name = "C14") private Integer c14 = 0;
	@Column(name = "C15") private Integer c15 = 0;
	@Column(name = "C16") private Integer c16 = 0;
	@Column(name = "C17") private Integer c17 = 0;
	@Column(name = "C18") private Integer c18 = 0;
	@Column(name = "C19") private Integer c19 = 0;
	@Column(name = "C20") private Integer c20 = 0;	
	@Column(name = "C21") private Integer c21 = 0;
	@Column(name = "C22") private Integer c22 = 0;
	@Column(name = "C23") private Integer c23 = 0;
	@Column(name = "C24") private Integer c24 = 0;
	@Column(name = "C25") private Integer c25 = 0;
	@Column(name = "C26") private Integer c26 = 0;
	@Column(name = "C27") private Integer c27 = 0;
	@Column(name = "C28") private Integer c28 = 0;
	@Column(name = "C29") private Integer c29 = 0;
	@Column(name = "C30") private Integer c30 = 0;
	@Column(name = "C31") private Integer c31 = 0;
	@Column(name = "C32") private Integer c32 = 0;
	@Column(name = "C33") private Integer c33 = 0;
	@Column(name = "C34") private Integer c34 = 0;
	@Column(name = "C35") private Integer c35 = 0;
	@Column(name = "C36") private Integer c36 = 0;
	@Column(name = "C37") private Integer c37 = 0;
	@Column(name = "C38") private Integer c38 = 0;
	@Column(name = "C39") private Integer c39 = 0; 
	@Column(name = "C40") private Integer c40 = 0; 
	@Column(name = "C41") private Integer c41 = 0; 
	@Column(name = "C42") private Integer c42 = 0;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getC01() {
		return c01;
	}
	public void setC01(Integer c01) {
		this.c01 = c01;
	}
	public Integer getC02() {
		return c02;
	}
	public void setC02(Integer c02) {
		this.c02 = c02;
	}
	public Integer getC03() {
		return c03;
	}
	public void setC03(Integer c03) {
		this.c03 = c03;
	}
	public Integer getC04() {
		return c04;
	}
	public void setC04(Integer c04) {
		this.c04 = c04;
	}
	public Integer getC05() {
		return c05;
	}
	public void setC05(Integer c05) {
		this.c05 = c05;
	}
	public Integer getC06() {
		return c06;
	}
	public void setC06(Integer c06) {
		this.c06 = c06;
	}
	public Integer getC07() {
		return c07;
	}
	public void setC07(Integer c07) {
		this.c07 = c07;
	}
	public Integer getC08() {
		return c08;
	}
	public void setC08(Integer c08) {
		this.c08 = c08;
	}
	public Integer getC09() {
		return c09;
	}
	public void setC09(Integer c09) {
		this.c09 = c09;
	}
	public Integer getC10() {
		return c10;
	}
	public void setC10(Integer c10) {
		this.c10 = c10;
	}
	public Integer getC11() {
		return c11;
	}
	public void setC11(Integer c11) {
		this.c11 = c11;
	}
	public Integer getC12() {
		return c12;
	}
	public void setC12(Integer c12) {
		this.c12 = c12;
	}
	public Integer getC13() {
		return c13;
	}
	public void setC13(Integer c13) {
		this.c13 = c13;
	}
	public Integer getC14() {
		return c14;
	}
	public void setC14(Integer c14) {
		this.c14 = c14;
	}
	public Integer getC15() {
		return c15;
	}
	public void setC15(Integer c15) {
		this.c15 = c15;
	}
	public Integer getC16() {
		return c16;
	}
	public void setC16(Integer c16) {
		this.c16 = c16;
	}
	public Integer getC17() {
		return c17;
	}
	public void setC17(Integer c17) {
		this.c17 = c17;
	}
	public Integer getC18() {
		return c18;
	}
	public void setC18(Integer c18) {
		this.c18 = c18;
	}
	public Integer getC19() {
		return c19;
	}
	public void setC19(Integer c19) {
		this.c19 = c19;
	}
	public Integer getC20() {
		return c20;
	}
	public void setC20(Integer c20) {
		this.c20 = c20;
	}
	public Integer getC21() {
		return c21;
	}
	public void setC21(Integer c21) {
		this.c21 = c21;
	}
	public Integer getC22() {
		return c22;
	}
	public void setC22(Integer c22) {
		this.c22 = c22;
	}
	public Integer getC23() {
		return c23;
	}
	public void setC23(Integer c23) {
		this.c23 = c23;
	}
	public Integer getC24() {
		return c24;
	}
	public void setC24(Integer c24) {
		this.c24 = c24;
	}
	public Integer getC25() {
		return c25;
	}
	public void setC25(Integer c25) {
		this.c25 = c25;
	}
	public Integer getC26() {
		return c26;
	}
	public void setC26(Integer c26) {
		this.c26 = c26;
	}
	public Integer getC27() {
		return c27;
	}
	public void setC27(Integer c27) {
		this.c27 = c27;
	}
	public Integer getC28() {
		return c28;
	}
	public void setC28(Integer c28) {
		this.c28 = c28;
	}
	public Integer getC29() {
		return c29;
	}
	public void setC29(Integer c29) {
		this.c29 = c29;
	}
	public Integer getC30() {
		return c30;
	}
	public void setC30(Integer c30) {
		this.c30 = c30;
	}
	public Integer getC31() {
		return c31;
	}
	public void setC31(Integer c31) {
		this.c31 = c31;
	}
	public Integer getC32() {
		return c32;
	}
	public void setC32(Integer c32) {
		this.c32 = c32;
	}
	public Integer getC33() {
		return c33;
	}
	public void setC33(Integer c33) {
		this.c33 = c33;
	}
	public Integer getC34() {
		return c34;
	}
	public void setC34(Integer c34) {
		this.c34 = c34;
	}
	public Integer getC35() {
		return c35;
	}
	public void setC35(Integer c35) {
		this.c35 = c35;
	}
	public Integer getC36() {
		return c36;
	}
	public void setC36(Integer c36) {
		this.c36 = c36;
	}
	public Integer getC37() {
		return c37;
	}
	public void setC37(Integer c37) {
		this.c37 = c37;
	}
	public Integer getC38() {
		return c38;
	}
	public void setC38(Integer c38) {
		this.c38 = c38;
	}
	public Integer getC39() {
		return c39;
	}
	public void setC39(Integer c39) {
		this.c39 = c39;
	}
	public Integer getC40() {
		return c40;
	}
	public void setC40(Integer c40) {
		this.c40 = c40;
	}
	public Integer getC41() {
		return c41;
	}
	public void setC41(Integer c41) {
		this.c41 = c41;
	}
	public Integer getC42() {
		return c42;
	}
	public void setC42(Integer c42) {
		this.c42 = c42;
	} 
	
	public void set(int lotteryNo) {
		switch (lotteryNo) {
			case 1  : setC01(1); break;
			case 2  : setC02(1); break;
			case 3  : setC03(1); break;
			case 4  : setC04(1); break;
			case 5  : setC05(1); break;
			case 6  : setC06(1); break;
			case 7  : setC07(1); break;
			case 8  : setC08(1); break;
			case 9  : setC09(1); break;
			case 10 : setC10(1); break;
			case 11 : setC11(1); break;
			case 12 : setC12(1); break;
			case 13 : setC13(1); break;
			case 14 : setC14(1); break;
			case 15 : setC15(1); break;
			case 16 : setC16(1); break;
			case 17 : setC17(1); break;
			case 18 : setC18(1); break;
			case 19 : setC19(1); break;
			case 20 : setC20(1); break;
			case 21 : setC21(1); break;
			case 22 : setC22(1); break;
			case 23 : setC23(1); break;
			case 24 : setC24(1); break;
			case 25 : setC25(1); break;
			case 26 : setC26(1); break;
			case 27 : setC27(1); break;
			case 28 : setC28(1); break;
			case 29 : setC29(1); break;
			case 30 : setC30(1); break;
			case 31 : setC31(1); break;
			case 32 : setC32(1); break;
			case 33 : setC33(1); break;
			case 34 : setC34(1); break;
			case 35 : setC35(1); break;
			case 36 : setC36(1); break;
			case 37 : setC37(1); break;
			case 38 : setC38(1); break;
			case 39 : setC39(1); break;
			case 40 : setC40(1); break;
			case 41 : setC41(1); break;
			case 42 : setC42(1); break;
			default: break;
		}
	}
}
