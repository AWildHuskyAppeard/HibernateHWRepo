package tw.group5.subarashiiproject.model.tajen.part2;

import java.util.*;

public interface ICartDAO {
	// 建立連線、提供SQL方法
	
	OrderBean insertOrder(OrderBean orderBean);
	OrderBean selectOrder(String P_ID);
	List<OrderBean> selectAllOrder();
	/**
	
	// 回傳資料筆數；0表示沒變化、-1表示出問題、1以上表示更改比數
	boolean updateOrder(OrderBean orderBean, String str3, Object obj4); 
	
	// order只會修正資料，紀錄會一直留下
	boolean deleteOrder(String O_ID); 
	*/
}
