package bangxin.yu;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import bangxin.yu.dao.InstituteDao;
import bangxin.yu.entity.InstituteEntity;


public class sshTest {
	@Autowired
	private InstituteDao instituteDao;

	@Test
	public void testInstitute() {
		List<InstituteEntity> list = instituteDao.findInstitute();
		for(int i = 0; i < list.size(); i++) {
			  System.out.println(list.get(i));
		}
	}
}
