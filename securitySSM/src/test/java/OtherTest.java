import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;

/**
 * @author lenovo
 * @create 2020-06-30 11:20
 **/
public class OtherTest {

    /**
     * 加密算法加密密码
     *
     * 即使同个密码，机密后也是不一样的结果，但这个结果与密码做matches匹配都返回true
     */
    @Test
    public void testEncode() {
        String password = "123";
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //哈希算法+加盐
        String encodedPassword = passwordEncoder.encode(password);
        System.out.println(encodedPassword);
        System.out.println(passwordEncoder.matches(password, encodedPassword));
        System.out.println(passwordEncoder.matches(password, "$2a$10$WCWY3vxS1q0ORY.VDNi4teKZi2V2HYwKKn5SndbnSXZ1Hl/zimeFy"));
    }
}
