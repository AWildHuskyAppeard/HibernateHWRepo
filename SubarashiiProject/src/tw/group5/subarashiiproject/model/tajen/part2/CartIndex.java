package tw.group5.subarashiiproject.model.tajen.part2;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.hibernate.Session;

public class CartIndex {
	
	public static ArrayList<ProductBean> cart = new ArrayList<ProductBean>();
	private final String format1 = "%10s | %20s | %20s | %20s | %20s | %20s ";
	private final String format2 = "%10s | %20s | %20s | %20d | %20s | %20s ";
	private Session session;
	private Scanner scanner = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		action();
	}
	
	public CartIndex(Session session) {
		this.session = session;
	}
	
	public static void action() {
		CartIndex cartIndex = new CartIndex();
		cartIndex.initialize();
		cartIndex.remoteControl();
		return;
	}
	
	public void remoteControl() {
		while(true) {
		System.out.println("輸入1以移除商品，2以確定結帳(把資料存進資料庫)，或其他回到主選單");
		String cmd = scanner.nextLine();
			if (cmd == "2" && cart.size() != 0) {
				pay(new OrderBean());
				backToMainPage();
				return;
			}
			if (cmd == "2" && cart.size() == 0) {
				System.out.println("Nothing in your cart :( ");
				continue;
			}
			else if (cmd == "1") {
				removeProductFromCart();
				continue;
			}
			else {
				backToMainPage();
				return;
			}
		}
	}
	
	private void removeProductFromCart() {
		while(true) {			
			System.out.println("Enter the No of product you'd like to remove OR other key to leave.");
			String n = scanner.nextLine();
			try {
				int no = Integer.parseInt(n);
				cart.remove(no);
				showCart();
			} catch (Exception e) {
				return;
			}
		}
	}

	private void backToMainPage() {
		return;		
	}

	private void pay(OrderBean orderbean) {
		
		Connection conn = getConn();
		CartDAO crudor = new CartDAO(conn);
		// ＊生成OrderBean
		
		// (1) 取得O_ID：查出最新的O_ID
		crudor.selectCustom("SELECT TOP(1) [O_ID] FROM [Order_Info] ORDER BY [O_ID] DESC;");
		ArrayList<ArrayList<String>> dataArrays = CartDAO.dataArrays;
		String O_IDString = dataArrays.get(0).get(0);
		// 剝掉非O_ID中非數字的部分取出轉成Integer
		String pureNum = stripNonDigits(O_IDString);
		Integer latestO_ID = Integer.parseInt(pureNum);
		// 找出當前Table裡O_ID最大數字，並+1
		// 97~122 = a~z; 65~90 = A~Z (ASCII表)
		// 單筆訂單內容上限 = 26筆
		ArrayList<String> newO_IDs = new ArrayList<String>();
		if (cart.size() > 1) {
			for(int i = 0; i < cart.size(); i++) {			
				String newO_ID = String.format("order%06d-%s", (latestO_ID + 1), (char)(65 + i));
				newO_IDs.add(newO_ID);
			}			
		} else {	
			String newO_ID = String.format("order%06d", (latestO_ID + 1));
			newO_IDs.add(newO_ID);
		}		
		
		// (2) 取得U_ID，U_FirstName，U_LastName，U_Email
		// 之後請若安把已登入會員的Bean幫我塞進session Attribute內，取出語句如下：
		// UserBean userBean = (UserBean)this.session.getAttribute("userBean");
		// 以下為測試用，要換掉
		ArrayList<UserBean> fakeUserBeans = new ArrayList<UserBean>();
		UserBean fakeUserBean00 = new UserBean("user01", "psww", "1098-12-31", "TKYM", "TMT", "L@U.L", "0987654321", "F", "this.Galaxy");
		fakeUserBeans.add(fakeUserBean00);
		
		// (3) 取得O_Date (使用SimpleDateFormat)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		String now = sdf.format(calendar.getTime());
		
		// (4) 取得O_Amt
		 Integer O_Amt = (Integer) session.getAttribute("O_Amt");
		
		// 把OrderBean的資料寫進去Database
		// 之後把下面fakeUserBeans.get(0)改成get(i)
		for(int i = 0; i < cart.size(); i++) {
			OrderBean orderBean = new OrderBean(newO_IDs.get(i), cart.get(i).getP_ID(), cart.get(i).getP_Name(), 
				cart.get(i).getP_Price(), fakeUserBeans.get(0).getU_ID(), fakeUserBeans.get(0).getU_FirstName(), 
				fakeUserBeans.get(0).getU_LastName(), fakeUserBeans.get(0).getU_Email(), "done", now, O_Amt);
			crudor.insertOrder(orderBean);
		}

		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		this.cart = new ArrayList<ProductBean>();
		session.setAttribute("cart", this.cart);
		session.removeAttribute("O_Amt");
		
//		req.getRequestDispatcher("/cart/cartThanks.jsp").forward(req, res);	 
		res.sendRedirect("/AwesomeProject/cart/cartThanks.jsp");
		return;
	}

	public void initialize() {
		ProductBean testBean1 = new ProductBean("p000003", "EN_Speaking", "EN", 500, "nice", "fbk001", "pic01", "vid01");
		ProductBean testBean2 = new ProductBean("p000015", "RU_Reading", "RU", 650, "awesome", "krn563", "pic02", "vid02");
		ProductBean testBean3 = new ProductBean("p000009", "JP_Translation", "JP", 500, "subarashii", "duck486", "pic03", "vid03");
//		<jsp:useBean id="addedProduct" scope="session" class="cart.ProductBean" type="cart.ProductBean" />

			// 測試用。cart如果是空的，會自動補3件下列商品作為測試
			if(cart.size() == 0) {
				System.out.println("購物車沒有任何東西，因此管理員塞了三個課程進來✌💀✌");
				cart = new ArrayList<ProductBean>();
				cart.add(testBean1);
				cart.add(testBean2);
				cart.add(testBean3);
			}
			showCart();
			return;
	}
	
	public void showCart() {
		System.out.println("**********************************************************************************************************************");
		System.out.println(String.format(format1, "No.", "課程名稱(P_Name)", "課程編號(P_ID)", 
				"課程價格(P_Price)", "課程介紹(P_DESC)", "課程老師(U_ID)"));
		Integer totalPrice = 0;
		for(int i = 0; i < cart.size(); i++) {
			if(cart != null) {
				System.out.println(String.format(format2, "(" + (i + 1) + ")", cart.get(i).getP_Name(), cart.get(i).getP_ID(),
						cart.get(i).getP_Price(), cart.get(i).getP_DESC(), cart.get(i).getU_ID()));
			}
			totalPrice += cart.get(i).getP_Price();
		}
		
		System.out.println(String.format("%20s%10d", "總計 = NT$", totalPrice));
//				session.setAttribute("O_Amt", totalPrice);
		System.out.println("**********************************************************************************************************************");
		return;		
	}
}
