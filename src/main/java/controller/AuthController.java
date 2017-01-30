package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.CredentialService;
import util.forms.CredentialForm;

import javax.validation.Valid;

@Controller
public class AuthController {

    @Autowired
    CredentialService credentialService;

    @RequestMapping("/login")
    public String showLoginPage(@RequestParam(value = "error", required = false) Boolean error, ModelMap map) {
        if (error == Boolean.TRUE) {
            map.addAttribute("error", true);
        }
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationPage(ModelMap map) {
        map.addAttribute("form", new CredentialForm());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("form") @Valid CredentialForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "registration";
        }
        credentialService.saveCredential(form);
        return "redirect:/login";
    }

}
