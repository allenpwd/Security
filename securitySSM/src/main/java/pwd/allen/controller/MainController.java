package pwd.allen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lenovo
 * @create 2019-09-11 9:46
 **/
@Controller
public class MainController {

    /**
     * 登录页面
     * @return
     */
    @RequestMapping("userLogin")
    public String main() {
        return "/login";
    }

    /**
     * 错误页面
     * @return
     */
    @RequestMapping("error")
    public String error() {
        return "/error";
    }
}
