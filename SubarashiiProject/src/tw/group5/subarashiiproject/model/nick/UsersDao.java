package tw.group5.subarashiiproject.model.nick;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class UsersDao implements IUsersDao {
//全域
	private Session session;
//建構子
	public UsersDao(Session session) {
		this.session = session;
	}
	
	@Override
	public boolean checkLoginAccess(String name, String pwd) {
		String hql = "from Users Where username=:user and userpwd=:upwd";
		Query<Users> query = session.createQuery(hql, Users.class);
		
		query.setParameter("user", name);
		query.setParameter("upwd", pwd);
		
		Users resultUser = query.uniqueResult();
		
		if(resultUser!=null) {
			return true;
		}
		return false ;
	}

}
