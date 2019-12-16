package bangxin.yu.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/****课程组信息表****/
@Entity
@Table(name = "coursegroup")
public class CourseGroupEntity {
	//课程组ID
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(generator = "id") // 注解----JPA通用策略生成器
	@GenericGenerator(name = "id", strategy = "assigned") // 注解----自定义主键生成策略
	private String id;
	
	//课程组名称
	@Column(name = "coursegroupName", nullable = false)
	private String coursegroupName;
	
	//学院名称
	@Column(name = "instituteName", nullable = false)
	private String instituteName;
	
	//创建日期
	@Column(name = "date", nullable = false)
	private Date date;
	
	/**
	 * @添加外键
	 * @多对一关系
	 * @cascade：配置级联操作
	 * @optional：关联是否可选。如果设置为false，则必须始终存在⾮空关系
	 * @foreignKey：更改外键信息
	 */
	@ManyToOne(cascade=CascadeType.ALL,optional=false)
	@JoinColumn(name = "instituteId",
			foreignKey = @ForeignKey(name = "FK_coursegroup_to_institute", 
		      	foreignKeyDefinition = "foreign key (instituteId) REFERENCES institute (id) ON DELETE CASCADE ON UPDATE CASCADE"))
	private InstituteEntity institute;

	/**
	 * @添加外键
	 * @一对多关系
	 * @mappedBy：放弃维权
	 * @cascade=CascadeType.ALL：配置级联操作
	 * @fetch：指定是否采⽤延迟加载
	 * @optional：关联是否可选。如果设置为false，则必须始终存在⾮空关系
	 */
	@OneToMany(mappedBy = "coursegroup",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<TeacherEntity> teacher;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCoursegroupName() {
		return coursegroupName;
	}

	public void setCoursegroupName(String coursegroupName) {
		this.coursegroupName = coursegroupName;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public InstituteEntity getInstitute() {
		return institute;
	}

	public void setInstitute(InstituteEntity institute) {
		this.institute = institute;
	}

	public List<TeacherEntity> getTeacher() {
		return teacher;
	}

	public void setTeacher(List<TeacherEntity> teacher) {
		this.teacher = teacher;
	}
	
}
