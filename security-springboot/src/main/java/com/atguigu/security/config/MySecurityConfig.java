package com.atguigu.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 启动spring security
 * security过滤器链
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 代替 <security:http></security:http>
     * 配置资源拦截；自定义过滤器；自定义登录、注销、记住我功能；
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        //定制请求的授权规则
        http.authorizeRequests()
                .antMatchers("/","/userlogin").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3")
                .antMatchers("/**").fullyAuthenticated();   //拦截所有请求的要放在最后，因为按照顺序判断的

        //开启自动配置的表单登陆功能，效果，如果没有登陆，没有权限就会来到登陆页面
        http.formLogin().usernameParameter("user").passwordParameter("pwd")
                .loginPage("/userlogin");
        //security自带的默认的登陆页地址是/login，可以用loginPage方法自定义login登录页地址
        //登陆失败默认重定向到 登录地址?error
        //默认post形式的 /login代表处理登陆，账号密码的参数名通过usernameParameter和passwordParameter指定
        //若定制了loginPage,那么loginPage的post请求就是处理登录的地址，也可以通过loginProcessingUrl指定


        //开启自动配置的注销功能。
        http.logout().logoutSuccessUrl("/");//注销成功以后来到首页
        //1、访问 /logout 表示用户注销，清空session
        //2、注销成功会返回 /login?logout 页面；

        //开启记住我功能
        http.rememberMe().rememberMeParameter("remember");
        //登陆成功以后，将cookie（remember-me）发给浏览器保存，以后访问页面带上这个cookie，只要通过检查就可以免登录
        //点击注销会删除cookie

    }

    /**
     * 定义认证规则，代替<security:authentication-manager></security:authentication-manager>
     * 管理账户名、密码，当前用户权限
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);

        //硬编码方式
        auth.inMemoryAuthentication()
                .withUser("zhangsan").password("123456").roles("VIP1","VIP2")
                .and()
                .withUser("lisi").password("123456").roles("VIP2","VIP3")
                .and()
                .withUser("wangwu").password("123456").roles("VIP1","VIP3");

        //自定义UserDetailService方式指定用户权限
//        auth.authenticationProvider(new MyUserDetailService());
    }
}
