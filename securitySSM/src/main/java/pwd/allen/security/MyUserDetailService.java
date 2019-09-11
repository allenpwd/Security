package pwd.allen.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * @author lenovo
 * @create 2019-09-11 13:21
 **/
public class MyUserDetailService implements UserDetailsService {

    /**
     * 根据用户名读取用户的信息（用户密码、权限）
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
        if ("pwd".equals(s)) {
            authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN");
        }
        User user = new User(s, "123", authorities);
        return user;
    }
}
