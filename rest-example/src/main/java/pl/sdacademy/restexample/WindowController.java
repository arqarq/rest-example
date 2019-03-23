package pl.sdacademy.restexample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WindowController {
    @RequestMapping("/")
    public String goToView() {
        return "/index-view.html";
    }
}
