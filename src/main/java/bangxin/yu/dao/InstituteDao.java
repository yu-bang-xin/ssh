package bangxin.yu.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import bangxin.yu.entity.InstituteEntity;


/*@Repository它用于将数据访问层 (DAO 层 ) 的类标识为 Spring Bean*/
@Repository("InstituteDao")
public interface InstituteDao extends JpaRepository<InstituteEntity, String> {
	@Modifying
  	@Query(value="delete from institute where id=?1 ",nativeQuery=true) 
  	int deleteInstitute(String id);
    
  	@Query(value="select * from institute",nativeQuery=true) 
    public List<InstituteEntity> findInstitute();
}
