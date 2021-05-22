package tw.group5.subarashiiproject.model.josh;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

	@Id @Column(name = "UID")
	private int uid;
	
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "USERPSW")
	private String userpsw;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {
		return userpsw;
	}

	public void setUserpwd(String userpwd) {
		this.userpsw = userpwd;
	}

}
