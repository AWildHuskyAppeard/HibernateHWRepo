package tw.group5.subarashiiproject.model.ken;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class UsersDao_ken implements IUsersDao_ken{
	
	private Session session;
	

	public UsersDao_ken(Session session) {
		this.session = session;
	}

	@Override
	public boolean checkLogInAccess(String usersAC, String usersPwd) {
		
		String hql = "from UserBean_ken where usersAC=:userac and usersPwd=:userpwd";
		
		Query<UserBean_ken> query = session.createQuery(hql, UserBean_ken.class);
		
		query.setParameter("userac", usersAC);
		query.setParameter("userpwd", usersPwd);
		
		UserBean_ken uniqueResult = query.uniqueResult();
		
		if (uniqueResult != null) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean insertNewUser(UserBean_ken uBean) {
		//check if ac is in db already
		UserBean_ken resultBean = session.get(UserBean_ken.class, uBean.getUserAC());
		
		if (resultBean == null) {
			session.save(uBean);
			return true;
		}
		return false;
	}

}
