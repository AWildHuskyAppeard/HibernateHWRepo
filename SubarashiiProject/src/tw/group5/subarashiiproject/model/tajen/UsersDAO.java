package tw.group5.subarashiiproject.model.tajen;
// PDF-1 TaJen

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class UsersDAO implements IUsersDAO {

	private Session session;
	
	public UsersDAO(Session session) {
		this.session = session;
	}
	
	@Override
	public boolean checkLoginAccess(String uname, String upsw) {
		String hql = "FROM Users WHERE username = :uname AND userpsw = :upsw";
		Query<Users> query = session.createQuery(hql, Users.class);
		
		query.setParameter("uname", uname);
		query.setParameter("upsw", upsw);
		
//		List<Users> list = query.list();
		Users resultUsers = query.uniqueResult();

		return (resultUsers != null)? true : false;
	}

	
}