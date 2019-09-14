package pwd.allen.security;

import com.google.code.kaptcha.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 校验 验证码
 *
 * @author 门那粒沙
 * @create 2019-09-14 21:56
 **/
public class KaptchaRequestFilter extends OncePerRequestFilter {

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //判断当前请求是否为登录请求
        if (request.getRequestURI().contains("/securityLogin")) {
            //校验验证码

            try {
                //获取用户输入的验证码
                final String imageCode = request.getParameter("imageCode");

                //获取系统生成的验证码
                String key = (String)request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);

                if (StringUtils.isEmpty(imageCode)) {
                    throw new ImageCodeException("验证码必须填写");
                }
                if (!imageCode.trim().equals(key)) {
                    throw new ImageCodeException("验证码不一致");
                }
            } catch (AuthenticationException e) {
                //交给自定义的AuthenticationFailureHandler处理
                authenticationFailureHandler.onAuthenticationFailure(request, response, e);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }
}
