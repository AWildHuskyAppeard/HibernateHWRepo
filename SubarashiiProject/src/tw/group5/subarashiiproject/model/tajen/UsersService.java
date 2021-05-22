package tw.group5.subarashiiproject.model.tajen;

import org.hibernate.Session;

public class UsersService implements IUsersService {

	private UsersDAO usersDAO;
	
	public UsersService(Session session) {
		this.usersDAO = new UsersDAO(session);
	}
	
	@Override
	public boolean checkLoginAccess(String uname, String upsw) {
		return this.usersDAO.checkLoginAccess(uname, upsw);
	}

}
