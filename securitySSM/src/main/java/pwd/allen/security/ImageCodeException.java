package pwd.allen.security;

import org.springframework.security.core.AuthenticationException;

/**
 * @author 门那粒沙
 * @create 2019-09-14 22:05
 **/
public class ImageCodeException extends AuthenticationException {

    public ImageCodeException(String msg, Throwable t) {
        super(msg, t);
    }

    public ImageCodeException(String msg) {
        super(msg);
    }
}
