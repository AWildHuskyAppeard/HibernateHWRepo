package tw.group5.subarashiiproject.model.nick;

import org.hibernate.Session;

public class UsersService implements IUsersService {

	private UsersDao uDao;

	public UsersService(Session session) {
		uDao = new UsersDao(session);
	}

	@Override
	public boolean checkLoginAccess(String name, String pwd) {
		return uDao.checkLoginAccess(name, pwd);
	}

}
