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

/****教师信息表****/
@Entity
@Table(name = "teacher_user")
public class TeacherEntity {
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
  	
  	//课程组名称
  	@Column(name = "coursegroupName", nullable = false)
  	private String coursegroupName;
  	
  	/**
	 * @添加外键
	 * @多对一关系
	 * @cascade：配置级联操作
	 * @optional：关联是否可选。如果设置为false，则必须始终存在⾮空关系
	 * @foreignKey：更改外键信息
	 */
	@ManyToOne(cascade=CascadeType.ALL,optional=false)
	@JoinColumn(name = "coursegroupId",
			foreignKey = @ForeignKey(name = "FK_teacher_to_coursegroup", 
		      	foreignKeyDefinition = "foreign key (coursegroupId) REFERENCES coursegroup (id) ON DELETE CASCADE ON UPDATE CASCADE"))
	private CourseGroupEntity coursegroup;

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

	public String getCoursegroupName() {
		return coursegroupName;
	}

	public void setCoursegroupName(String coursegroupName) {
		this.coursegroupName = coursegroupName;
	}

	public CourseGroupEntity getCoursegroup() {
		return coursegroup;
	}

	public void setCoursegroup(CourseGroupEntity coursegroup) {
		this.coursegroup = coursegroup;
	}

}
