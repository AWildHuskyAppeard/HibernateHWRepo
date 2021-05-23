package tw.group5.subarashiiproject.model.josh;

public interface IUsersDao {
	//檢查帳號密碼
	public boolean checkLoginAccess(String uname, String upsw);
}
