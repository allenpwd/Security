import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author lenovo
 * @create 2020-06-30 11:20
 **/
public class OtherTest {

    /**
     * 加密算法加密密码
     */
    @Test
    public void testEncode() {
        String password = "123";
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //哈希算法+加盐
        String encodedPassword = passwordEncoder.encode(password);
        System.out.println(encodedPassword);
        System.out.println(passwordEncoder.matches(password, encodedPassword));
    }
}
