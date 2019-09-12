package pwd.allen.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.CollectionUtils;
import pwd.allen.dao.UserMapper;
import pwd.allen.entity.Auth;
import pwd.allen.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lenovo
 * @create 2019-09-11 13:21
 **/
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户名读取用户的信息（用户密码、权限）
     * 注意：该方法规定不能返回null，所以如果为null的话可以抛出异常
     *
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        //根据用户名查询用户信息
        User user = userMapper.selectByUserName(s);
        if (user == null) throw new RuntimeException("帐号不存在");

        //根据用户名查询当前用户的所有权限
        List<Auth> auths = userMapper.selectAuthByUserName(s);
        List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

        if (!CollectionUtils.isEmpty(auths)) {
            for (Auth auth : auths) {
                SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(auth.getAuthName());
                authorities.add(simpleGrantedAuthority);
            }
            user.setAuthorities(authorities);
        }

        return user;
    }
}
