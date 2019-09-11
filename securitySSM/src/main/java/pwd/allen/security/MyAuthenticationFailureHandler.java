package pwd.allen.security;

import com.alibaba.fastjson.JSON;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * 自定义登录失败后返回的信息，这里返回Json信息
 *
 * @author lenovo
 * @create 2019-09-11 14:34
 **/
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

    /**
     *
     *
     * @param request
     * @param response
     * @param e
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        HashMap<Object, Object> result = new HashMap<>();
        result.put("type", "error");
        result.put("msg", e.getMessage());

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(result));
    }
}
