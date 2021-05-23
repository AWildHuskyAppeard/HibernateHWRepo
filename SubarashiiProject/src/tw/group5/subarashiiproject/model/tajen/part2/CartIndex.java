package tw.group5.subarashiiproject.model.tajen.part2;

import java.util.*;

public class CartIndex {
	
	public static ArrayList<ProductBean> cart;
	private final String format1 = "%5s | %20s | %20s | %20s | %20s | %20s ";
	private final String format2 = "%5s | %20s | %20s | %20d | %20s | %20s ";
	private Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		CartIndex cartIndex = new CartIndex();
		cartIndex.initialize();
		
	}
	
	public CartIndex() {}
	
	public void remoteControl() {
		System.out.println("輸入1以移除商品，2以確定結帳(把資料存進資料庫)，或其他回到主選單");
		int cmd1 = scanner.nextInt();
		if (cmd1 == 2) insertOrderInfo();
		else if (cmd1 == 1) removeProductFromCart();
		else backToMainPage();
	}
	
	private void removeProductFromCart() {
		System.out.println("Which product would you like to remove?");
		
	}

	private void backToMainPage() {
		// TODO Auto-generated method stub
		return;		
	}

	private void insertOrderInfo() {
		// TODO Auto-generated method stub
		
	}

	public void initialize() {
		ProductBean testBean1 = new ProductBean("p000003", "EN_Speaking", "EN", 500, "nice", "fbk001", "pic01", "vid01");
		ProductBean testBean2 = new ProductBean("p000015", "RU_Reading", "RU", 650, "awesome", "krn563", "pic02", "vid02");
		ProductBean testBean3 = new ProductBean("p000009", "JP_Translation", "JP", 500, "subarashii", "duck486", "pic03", "vid03");
//		<jsp:useBean id="addedProduct" scope="session" class="cart.ProductBean" type="cart.ProductBean" />

			// 測試用。cart如果是空的，會自動補3件下列商品作為測試
			if(cart == null || cart.size() == 0) {
				System.out.println("購物車沒有任何東西，因此管理員塞了三個課程進來✌💀✌");

				cart = new ArrayList<ProductBean>();
				cart.add(testBean1);
				cart.add(testBean2);
				cart.add(testBean3);
			}
			showCart();
			

	}
	
	public void showCart() {
		System.out.println("***********************************************************");
		System.out.println(String.format(format1, "", "課程名稱(P_Name)", "課程編號(P_ID)", 
				"課程價格(P_Price)", "課程介紹(P_DESC)", "課程老師(U_ID)"));
		Integer totalPrice = 0;
		for(int i = 0; i < cart.size(); i++) {
			if(cart != null) {
				System.out.println(String.format(format2, "(" + (i + 1) + ")", cart.get(i).getP_Name(), cart.get(i).getP_ID(),
						cart.get(i).getP_Price(), cart.get(i).getP_DESC(), cart.get(i).getU_ID()));
			}
			totalPrice += cart.get(i).getP_Price();
		}
		
		System.out.println(String.format("%90s%10d", "總計 = NT$", totalPrice));
//				session.setAttribute("O_Amt", totalPrice);
		System.out.println("***********************************************************");
		
		
	}
}
