package tw.group5.subarashiiproject.model.tajen.part2;
// 購物車的連線物件
// 要考慮做DAO Factory嗎？
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class CartDAO implements ICartDAO {
	private Session session;
	// dataArrays在每次執行selectAllOrder()或selectOrder()時都會先被重製，
	// 其他需要重製的時候需要手動重製。
	public static ArrayList<ArrayList<String>> dataArrays;
	public static OrderBean odBean01 = new OrderBean("od001", "p001", "EngSpeaking", 300, "elf01", "fl", "b", "w@w", "cancelled", "1999-12-01 00:00:00", 1 );
	public static final String columnNames[] = {"O_ID", "P_ID", "P_Name", "P_Price", "U_ID", "U_FirstName", "U_LastName",
			"U_Email", "O_Status", "O_Date", "O_Amt"};
	
	public CartDAO(Session session) {
		this.session = session;
	}
	
	@Override
	public OrderBean insertOrder(OrderBean orderBean) {
		// ***
//		session.beginTransaction();
		// O_ID感覺沒辦法用在下述
		OrderBean resultBean = session.get(OrderBean.class, orderBean.getO_ID());
		if (resultBean == null) {
			this.session.save(resultBean);
			return resultBean;
		} else {
			System.out.println("Order exists already.");
			return null;
//		session.getTransaction().commit();
		}
	}
	
	@Override
	public List<OrderBean> selectAllOrder() {
		Query<OrderBean> query = session.createQuery("FROM Order_Info", OrderBean.class);
		return query.list();
	}
	
	@Override
	public OrderBean selectOrder(String P_ID) {
		// HQL好像不是用table名而是entity名，所以有可能是OrderBean
		Query<OrderBean> query = session.createQuery("SELECT * FROM Order_Info WHERE p_id = :pid", OrderBean.class);
		query.setParameter("pid", P_ID);
		return query.uniqueResult();
	}

	@Override
	public OrderBean selectCustom(String hql) {
//		this.session.createQuery(hql, OrderBean.class);
		return null;
	}

}
