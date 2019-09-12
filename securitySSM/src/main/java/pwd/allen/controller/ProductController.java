package pwd.allen.controller;

import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lenovo
 * @create 2019-09-10 18:25
 **/
@Controller
@RequestMapping("/product")
public class ProductController {

    /**
     * 商品添加
     *
     * @param request
     * @return
     */
    @RequestMapping("index")
    public String index(HttpServletRequest request) {
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
