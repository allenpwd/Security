import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pwd.allen.dao.UserMapper;
import pwd.allen.entity.Auth;
import pwd.allen.entity.User;

import java.util.List;

/**
 * @author lenovo
 * @create 2019-09-12 16:18
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        List<Auth> list = userMapper.selectAuthByUserName("pwd");
        System.out.println(list);

        User user = userMapper.selectById(1);
        System.out.println(user);
    }
}
