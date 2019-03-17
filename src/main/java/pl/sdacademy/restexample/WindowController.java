package pl.sdacademy.restexample;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/windows")
public class WindowController {
    private WindowRepository windowRepository;

    private WindowController(WindowRepository windowRepository) {
        this.windowRepository = windowRepository;
    }

    @GetMapping
    public List<Window> getAll() {
        // return Arrays.asList(
        //         new Window(100, 200),
        //         new Window(250, 150),
        //         new Window(200, 300)
        // );
        return windowRepository.findAll();
    }

    @PostMapping
    public Window create(@RequestBody Window window) {
        return windowRepository.save(window); // dla konsoli firefox - brak błędy gdy coś zwróci
    }

    @DeleteMapping("/{id}")
    public Window delete(@PathVariable long id) {
        Optional<Window> byId = windowRepository.findById(id);
        byId.ifPresent(window -> windowRepository.delete(window));
        return new Window();  // dla konsoli firefox - brak błędy gdy coś zwróci
    }
}
