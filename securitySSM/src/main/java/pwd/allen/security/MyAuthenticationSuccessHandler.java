package pwd.allen.security;

import com.fasterxml.jackson.databind.ObjectMapper;
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
     * json框架工具类，用于转换对象为json字符串
     */
    private ObjectMapper objectMapper = new ObjectMapper();

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
        response.getWriter().write(objectMapper.writeValueAsString(result));
    }
}
