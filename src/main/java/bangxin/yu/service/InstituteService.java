package bangxin.yu.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import bangxin.yu.dao.InstituteDao;
import bangxin.yu.entity.InstituteEntity;

@Service("InstituteService")
public class InstituteService { 
     /**
	 *@Spring将@Resource注解的name属性解析为bean的名字，
	 *@type属性则解析为bean的类型
	 **/	
	@Resource(name = "InstituteDao")
	private InstituteDao instituteDao;
	
	/**
	 *@添加学院 
	 *@Transactional 注解管理事务
	 **/	
	@Transactional
	public void addInstitute(InstituteEntity addIns) {
		instituteDao.save(addIns);
	}
	
	@Transactional
	public int deleteInstitute(String id){
        return instituteDao.deleteInstitute(id);
    }
	
}
