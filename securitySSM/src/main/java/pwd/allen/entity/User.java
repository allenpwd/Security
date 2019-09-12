package pwd.allen.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;

    private String username;

    private String password;

    private Date createDate;

    private Date lastLoginTime;

    private Boolean enabled;

    private Boolean nonExpired;

    private Boolean nonLocked;

    private Boolean credentialsNonExpired;

}