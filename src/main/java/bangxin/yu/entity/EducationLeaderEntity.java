package bangxin.yu.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/****教学负责人信息表****/
@Entity
@Table(name = "educationleader_user")
public class EducationLeaderEntity {
	//用户ID
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(generator = "id") // 注解----JPA通用策略生成器
	@GenericGenerator(name = "id", strategy = "assigned") // 注解----自定义主键生成策略
	private String id;
	
	//用户名
	@Column(name = "userName", nullable = false)
	private String userName;
	
	//密码
	@Column(name = "password", nullable = false)
	private String password;
	
	//账号
	@Column(name = "account", nullable = false)
	private String account;
	
	//创建日期
	@Column(name = "date", nullable = false)
	private Date date;
	
	//角色Id
    @Column(name = "roleId", nullable = false)
	private String roleId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}
