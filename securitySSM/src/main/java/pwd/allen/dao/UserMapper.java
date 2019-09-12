package pwd.allen.dao;

import org.apache.ibatis.annotations.Select;
import pwd.allen.entity.Auth;
import pwd.allen.entity.User;

import java.util.List;

public interface UserMapper {

    /**
     * @param userName
     * @return
     */
    public User selectByUserName(String userName);

    /**
     *
     * @param id
     * @return
     */
    @Select("select * from sys_user where id=#{id}")
    public User selectById(Integer id);

    /**
     * 查询当前用户拥有的权限
     * @param userName
     * @return
     */
    public List<Auth> selectAuthByUserName(String userName);

    public int insert(User user);

    public int update(User user);
}