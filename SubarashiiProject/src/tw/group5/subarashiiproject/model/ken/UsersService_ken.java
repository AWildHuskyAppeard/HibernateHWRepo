package tw.group5.subarashiiproject.model.ken;

import org.hibernate.Session;

public class UsersService_ken implements IUsersService_ken {
	
	private UsersDao_ken usersDao;
	
	public UsersService_ken(Session session) {
		usersDao = new UsersDao_ken(session);
	}

	@Override
	public boolean checkLogInAccess(String usersAC, String usersPwd) {
		return usersDao.checkLogInAccess(usersAC, usersPwd);
	}

	@Override
	public boolean insertNewUser(UserBean_ken uBean) {
		return usersDao.insertNewUser(uBean);
	}

}
