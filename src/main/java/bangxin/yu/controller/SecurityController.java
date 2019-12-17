package bangxin.yu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
	/**
     * @首页
     */
    @GetMapping("/index")
    public String index() {
       return "index";
    }
    
    /**
     * @welcome
     */
    @GetMapping("/welcome")
    public String welcome() {
       return "welcome";
    }
    
    /**
     * @学院信息页
     */
    @GetMapping("/institute")
    public String institute() {
       return "institute";
    }
    
    /**
     * @学院信息页
     */
    @GetMapping("/institute_add")
    public String institute_add() {
       return "institute_add";
    }
}
