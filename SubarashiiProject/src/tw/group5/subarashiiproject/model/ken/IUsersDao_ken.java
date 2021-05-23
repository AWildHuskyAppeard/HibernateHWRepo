package tw.group5.subarashiiproject.model.ken;

public interface IUsersDao_ken {
	public boolean checkLogInAccess(String usersAC, String usersPwd);
	public boolean insertNewUser(UserBean_ken uBean);
}
