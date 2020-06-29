package pwd.allen.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
public class User implements UserDetails {
    private Integer id;

    private String username;

    private String password;

    private Date createDate;

    private Date lastLoginTime;

    private boolean isEnabled;

    private boolean isAccountNonExpired;

    private boolean isAccountNonLocked;

    private boolean isCredentialsNonExpired;

    /**
     * 用户拥有的所有权限
     */
    private List<GrantedAuthority> authorities = new ArrayList<>();

}