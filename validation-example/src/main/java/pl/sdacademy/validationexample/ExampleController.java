package pl.sdacademy.validationexample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
    @GetMapping("example/{param}")
    public String example(@PathVariable String param) {
        if ("xyz".equals(param)) {
            throw new RuntimeException("nieprawidłowa wartość parametru");
        }
        return "OK: " + param;
    }
}
