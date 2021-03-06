package tw.group5.subarashiiproject.model.josh;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class UsersDao implements IUsersDao{

	private Session session;

	public UsersDao(Session session) {
		this.session = session;
	}
	@Override
	public boolean checkLoginAccess(String uname, String upsw) {
		String hql = "from Users1 Where username=:uname and userpsw=:upsw";
		Query<Users1> query = session.createQuery(hql, Users1.class);
		
		query.setParameter("uname", uname);
		query.setParameter("upsw", upsw);
		
		Users1 userResult = query.uniqueResult();
		
		return (userResult!=null)? true:false ;
	}
	
}
