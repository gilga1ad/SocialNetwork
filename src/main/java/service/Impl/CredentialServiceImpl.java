package service.Impl;


import model.Credential;
import model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.CredentialRepository;
import repository.RoleRepository;
import service.CredentialService;
import util.forms.CredentialForm;
import util.transformers.CredentialFormTransformer;

import javax.annotation.PostConstruct;

@Service
@Transactional(readOnly = true)
public class CredentialServiceImpl implements CredentialService {

    private static final String DEFAULT_ROLE_NAME = "ROLE_USER";
    private Role defaultRole;

    @Autowired
    CredentialRepository credentialRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    CredentialFormTransformer transformer;

    @PostConstruct
    private void initialize() {
        defaultRole = roleRepository.findByName(DEFAULT_ROLE_NAME);
    }

    @Transactional
    @Override
    public void saveCredential(CredentialForm form) {
        Credential credential = transformer.toCredential(form);
        credential.getRoles().add(defaultRole);
        credentialRepository.save(credential);
    }

}
