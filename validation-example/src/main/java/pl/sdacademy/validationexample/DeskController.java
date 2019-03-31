package pl.sdacademy.validationexample;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/desks")
public class DeskController {
    private DeskRepository deskRepository;

    public DeskController(DeskRepository deskRepository) {
        this.deskRepository = deskRepository;
    }

    @PostMapping
    public Desk create(@RequestBody Desk desk) {
        return deskRepository.save(desk);
    }
}
