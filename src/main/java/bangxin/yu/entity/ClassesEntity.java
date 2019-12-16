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

/****班级信息表****/
@Entity
@Table(name = "classes")
public class ClassesEntity {
	//班级ID
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(generator = "id") // 注解----JPA通用策略生成器
	@GenericGenerator(name = "id", strategy = "assigned") // 注解----自定义主键生成策略
	private String id;
	
	//班级名称
	@Column(name = "className", nullable = false)
	private String className;
	
	//学院名称
	@Column(name = "instituteName", nullable = false)
	private String instituteName;
	
	//学院Id
	@Column(name = "instituteId", nullable = false)
	private String instituteId;
	
	//专业名称
	@Column(name = "specializedName", nullable = false)
	private String specializedName;
	
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
	//专业Id,specializedId:外键
	@JoinColumn(name = "specializedId",
			foreignKey = @ForeignKey(name = "FK_classes_to_specialized", 
		      	foreignKeyDefinition = "foreign key (specializedId) REFERENCES specialized (id) ON DELETE CASCADE ON UPDATE CASCADE"))
	private SpecializedEntity specialized;

	/**
	 * @添加外键
	 * @一对多关系
	 * @mappedBy：放弃维权
	 * @cascade=CascadeType.ALL：配置级联操作
	 * @fetch：指定是否采⽤延迟加载
	 * @optional：关联是否可选。如果设置为false，则必须始终存在⾮空关系
	 */
	@OneToMany(mappedBy = "classes",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<StudentEntity> student;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public SpecializedEntity getSpecialized() {
		return specialized;
	}

	public void setSpecialized(SpecializedEntity specialized) {
		this.specialized = specialized;
	}

	public List<StudentEntity> getStudent() {
		return student;
	}

	public void setStudent(List<StudentEntity> student) {
		this.student = student;
	}
	
}
