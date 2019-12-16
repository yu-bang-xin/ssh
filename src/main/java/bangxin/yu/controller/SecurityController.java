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
}
