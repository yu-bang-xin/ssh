package bangxin.yu.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import bangxin.yu.entity.AdminUserEntity;

/*@Repository它用于将数据访问层 (dao层)的类标识为 Spring Bean*/
/*管理员dao层*/
@Repository("AdminUserDao")
public interface AdminUserDao extends JpaRepository<AdminUserEntity, String> {
    /** 
	 *@查询admin_user中是否已存在某账号，避免重复添加 
	 *@nativeQuery=true：使用原生sql查询
	 **/
	@Query(value="select count(1) from admin_user where userName=?1",nativeQuery=true)
	public int queryAdminUser(String userName);
    
	/**
	 * @查询管理员信息 
	 **/
//    @Query(value="select * from admin_user",nativeQuery=true)
//    public List<Admin_User> queryAdmin_User();

}