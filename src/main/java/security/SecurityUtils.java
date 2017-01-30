package security;

import model.Credential;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

    public static Credential getCurrentCredential() {
        return (Credential) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
