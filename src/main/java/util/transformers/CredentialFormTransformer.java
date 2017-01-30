package util.transformers;

import model.Credential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import util.forms.CredentialForm;

@Component
public class CredentialFormTransformer {

    @Autowired
    public BCryptPasswordEncoder encoder;

    public Credential toCredential(CredentialForm form) {
        Credential credential = new Credential();
        credential.setEmail(form.getEmail());
        credential.setPassword(encoder.encode(form.getPassword()));

        credential.getUser().setFirstName(form.getFirstName());
        credential.getUser().setLastName(form.getLastName());
        return credential;
    }

}
