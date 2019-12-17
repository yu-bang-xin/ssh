package bangxin.yu.service;

import java.util.Date;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import bangxin.yu.config.MD5Tools;
import bangxin.yu.dao.AdminUserDao;
import bangxin.yu.entity.AdminUserEntity;


/*管理员service层*/
@Service("AdminUserService")
public class AdminUserService {
     /**
	 *@Spring将@Resource注解的name属性解析为bean的名字，
	 *@type属性则解析为bean的类型
	 **/	
	@Resource(name = "AdminUserDao")
	private AdminUserDao adminUserDao;
	
	/**
	 *@生成管理员
	 *@Transactional 注解管理事务
	 *@PostConstruct 启动spring容器时该注解标记的方法会执行
	 **/	
	@PostConstruct
	@Transactional
	public void createAdmin() {
		int result = adminUserDao.queryAdminUser("admin");
		if(result==0) {
			AdminUserEntity admin = new AdminUserEntity();
			admin.setUserName("admin");  //用户名
			admin.setPassword(MD5Tools.convertMD5("admin"));//密码
			admin.setDate(new Date());   //用户创建日期
			admin.setId(UUID.randomUUID().toString().replace("-", ""));//用UUID生成用户Id
			admin.setRoleId("1");      //设定角色Id:1
			admin.setAccount("admin"); //账号
			adminUserDao.save(admin);
		}
	}

}
