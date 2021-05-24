package tw.group5.subarashiiproject.model.nick;

public interface IUsersDao {
	public boolean checkLoginAccess(String name, String pwd);
}
