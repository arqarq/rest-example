package pl.sdacademy.securityexample;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @CrossOrigin
    @PostMapping("/login")
    public void login() {

    }
}
