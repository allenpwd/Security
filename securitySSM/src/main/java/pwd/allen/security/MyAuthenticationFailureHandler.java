package pwd.allen.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

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
     * json框架工具类，用于转换对象为json字符串
     */
    private ObjectMapper objectMapper = new ObjectMapper();

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
        response.getWriter().write(objectMapper.writeValueAsString(result));
    }
}
