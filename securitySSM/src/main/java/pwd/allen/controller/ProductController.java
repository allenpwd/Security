package pwd.allen.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pwd.allen.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lenovo
 * @create 2019-09-10 18:25
 **/
@Controller
@RequestMapping("/product")
public class ProductController {

    /**
     * 首页
     *
     * @param request
     * @return
     */
    @RequestMapping("index")
    public String index(HttpServletRequest request, Model model) {

        //获取用户登录信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal != null && principal instanceof User) {
            String username = User.class.cast(principal).getUsername();
            model.addAttribute("username", username);
        }

        return "index";
    }

    /**
     * 商品添加
     *
     * @param request
     * @return
     */
    @RequestMapping("update")
    public String update(HttpServletRequest request) {
        return "product/update";
    }

    /**
     * 商品添加
     *
     * @param request
     * @return
     */
    @RequestMapping("add")
    public String addProduct(HttpServletRequest request) {
        return "product/add";
    }

    /**
     * 商品添加
     *
     * @param request
     * @return
     */
    @RequestMapping("delete")
    public String delete(HttpServletRequest request) {
        return "product/delete";
    }

    /**
     * 商品添加
     *
     * @param request
     * @return
     */
    @RequestMapping("list")
    public String list(HttpServletRequest request) {
        return "product/list";
    }
}
