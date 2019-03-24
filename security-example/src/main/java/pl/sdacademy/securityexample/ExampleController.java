package pl.sdacademy.securityexample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
    @GetMapping
    public String example() {
        return "abcde";
    }
}
