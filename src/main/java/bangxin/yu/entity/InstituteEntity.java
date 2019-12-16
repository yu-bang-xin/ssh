package bangxin.yu.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/****学院信息表****/
@Entity
@Table(name = "institute")
public class InstituteEntity {
	//学院ID
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(generator = "id") // 注解----JPA通用策略生成器
	@GenericGenerator(name = "id", strategy = "assigned") // 注解----自定义主键生成策略
	private String id;
	
	//学院名称
	@Column(name = "instituteName", nullable = false)
	private String instituteName;
	
	//创建日期
	@Column(name = "date", nullable = false)
	private Date date;

	/**
	 * @添加外键
	 * @一对多关系
	 * @mappedBy：放弃维权
	 * @cascade=CascadeType.ALL：配置级联操作
	 * @fetch：指定是否采⽤延迟加载
	 * @optional：关联是否可选。如果设置为false，则必须始终存在⾮空关系
	 */
	@OneToMany(mappedBy = "institute",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<SpecializedEntity> specialized;

	public String getId() {
		
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public List<SpecializedEntity> getSpecialized() {
		return specialized;
	}

	public void setSpecialized(List<SpecializedEntity> specialized) {
		this.specialized = specialized;
	}

}
