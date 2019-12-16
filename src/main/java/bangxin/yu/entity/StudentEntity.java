package bangxin.yu.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/****学生信息表****/
@Entity
@Table(name = "student_user")
public class StudentEntity {
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

    //学院名称
  	@Column(name = "instituteName", nullable = false)
  	private String instituteName;
  	
  	//学院Id 
  	@Column(name = "instituteId", nullable = false)
  	private String instituteId;
  	
    //专业名称
  	@Column(name = "specializedName", nullable = false)
  	private String specializedName;
  	
  	//专业Id
  	@Column(name = "specializedId", nullable = false)
  	private String specializedId;
  	
  	//班级名称
  	@Column(name = "className", nullable = false)
  	private String className;
  	
  	/**
	 * @添加外键
	 * @多对一关系
	 * @cascade：配置级联操作
	 * @optional：关联是否可选。如果设置为false，则必须始终存在⾮空关系
	 * @foreignKey：更改外键信息
	 */
	@ManyToOne(cascade=CascadeType.ALL,optional=false)
	@JoinColumn(name = "classId",
			foreignKey = @ForeignKey(name = "FK_student_to_class", 
		      	foreignKeyDefinition = "foreign key (classId) REFERENCES classes (id) ON DELETE CASCADE ON UPDATE CASCADE"))
	private ClassesEntity classes;

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

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(String instituteId) {
		this.instituteId = instituteId;
	}

	public String getSpecializedName() {
		return specializedName;
	}

	public void setSpecializedName(String specializedName) {
		this.specializedName = specializedName;
	}

	public String getSpecializedId() {
		return specializedId;
	}

	public void setSpecializedId(String specializedId) {
		this.specializedId = specializedId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public ClassesEntity getClasses() {
		return classes;
	}

	public void setClasses(ClassesEntity classes) {
		this.classes = classes;
	}
	
}
