package tw.group5.subarashiiproject.model.josh;

import org.hibernate.Session;

public class UsersService implements IUsersService {
	private UsersDao userDao;
	
	public UsersService(Session session) {
		this.userDao = new UsersDao(session);
	}

	@Override
	public boolean checkLoginAccess(String uname, String upsw) {
		return userDao.checkLoginAccess(uname, upsw);
	}

}
