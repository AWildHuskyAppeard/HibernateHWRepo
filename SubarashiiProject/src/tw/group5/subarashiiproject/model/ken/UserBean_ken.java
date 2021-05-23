package tw.group5.subarashiiproject.model.ken;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserBean_ken {
	
	//user's attribute
	@Id
	@Column(name = "userAC")
	private String usersAC;
	@Column(name = "userPwd")
	private String usersPwd;
	
	//getter & setter
	public String getUserAC() {
		return usersAC;
	}
	public void setUserAC(String userAC) {
		this.usersAC = userAC;
	}
	public String getUserPwd() {
		return usersPwd;
	}
	public void setUserPwd(String userPwd) {
		this.usersPwd = userPwd;
	}
	@Override
	public String toString() {
		return "UserBean [ userAC=" + usersAC + ", userPwd=" + usersPwd + "]";
	}
	
	
	
	
}
