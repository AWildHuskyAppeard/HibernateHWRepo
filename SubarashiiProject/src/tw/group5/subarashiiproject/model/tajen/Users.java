package tw.group5.subarashiiproject.model.tajen;
// PDF-1 Ta-Jen
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//@Entity(name = "Users") > 預設；避免和各位衝到所以改成下述。另外HQL的部分也要改。
@Entity(name = "Usersnin")
@Table(name = "users")
public class Users {
	// attributes
	@Id @Column(name = "UID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uid;
	@Column(name = "USERNAME")
	private String username;
	@Column(name = "USERPSW")
	private String userpsw;
	
	// constructors
	
	// getters
	public Integer getUid() {		return uid;	}
	public String getUsername() {		return username;	}
	public String getUserpsw() {		return userpsw;	}
	
	// setters
	public void setUid(Integer uid) {		this.uid = uid;	}
	public void setUsername(String username) {		this.username = username;	}
	public void setUserpsw(String userpsw) {		this.userpsw = userpsw;	}
	
	
}
