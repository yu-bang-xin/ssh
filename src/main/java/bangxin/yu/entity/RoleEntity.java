package bangxin.yu.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/****角色/权限信息表****/
@Entity
@Table(name = "role")
public class RoleEntity {
	//角色ID
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(generator = "id") // 注解----JPA通用策略生成器
	@GenericGenerator(name = "id", strategy = "assigned") // 注解----自定义主键生成策略
	private String id;
	
	//角色名称
	@Column(name = "roleName", nullable = false)
	private String roleName;
	
	//角色权限
	@Column(name = "roleAuthority", nullable = false)
	private String roleAuthority;
	
	//权限描述
	@Column(name = "content", nullable = false)
	private String content;
	
	//创建日期
	@Column(name = "date", nullable = false)
	private Date date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleAuthority() {
		return roleAuthority;
	}

	public void setRoleAuthority(String roleAuthority) {
		this.roleAuthority = roleAuthority;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
    
}
