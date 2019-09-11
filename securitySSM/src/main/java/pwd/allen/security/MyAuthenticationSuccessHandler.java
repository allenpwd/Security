package pwd.allen.security;

import com.alibaba.fastjson.JSON;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * 自定义登录成功后返回的信息，这里返回Json信息
 *
 * @author lenovo
 * @create 2019-09-11 14:34
 **/
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    /**
     * Authentication：认证成功后的信息
     *
     * @param request
     * @param response
     * @param authentication
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        HashMap<Object, Object> result = new HashMap<>();
        result.put("type", "success");

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(result));
    }
}
