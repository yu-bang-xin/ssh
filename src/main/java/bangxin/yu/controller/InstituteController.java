package bangxin.yu.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;

import bangxin.yu.entity.InstituteEntity;
import bangxin.yu.service.InstituteService;


@RestController
@CrossOrigin
public class InstituteController {
	@Resource(name = "InstituteService")
	private InstituteService instituteService;

	/**
	 *@添加学院  
	 **/
	@RequestMapping(value = "/addInstitute", method = RequestMethod.POST)
	public String addInstitute(InstituteEntity addIns) { 
		addIns.setDate(new Date());                             
		addIns.setId(UUID.randomUUID().toString().replace("-", "")); //用UUID生成学院Id
		addIns.setInstituteName("网安学院");
		instituteService.addInstitute(addIns);
		return new Gson().toJson(addIns);
	}

	@RequestMapping(value = "/deleteInstitute", method = RequestMethod.POST)
	public Map<String, Object> deleteInstitute(@RequestBody Map<String, String> map){ 
		String id = map.get("id"); 
		int status=instituteService.deleteInstitute(id);
		Map<String, Object> resultMap=new HashMap<>();
		resultMap.put("status",status);
        return resultMap;
	}
}
