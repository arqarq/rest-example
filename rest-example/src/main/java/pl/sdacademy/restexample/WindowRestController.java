package pl.sdacademy.restexample;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/windows")
public class WindowRestController {
    private static final Logger LOG = Logger.getLogger(RestExampleApplication.class.getName());
    private WindowRepository windowRepository;

    private WindowRestController(WindowRepository windowRepository) {
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
        Window window = windowRepository.findById(id).orElseGet(Window::new);
        // .orElseThrow(() -> new RuntimeException("Brak okna o zadanym id"));
        if (window.getId() != null) {
            windowRepository.delete(window);
            return window; // dla konsoli firefox - brak błędu gdy coś zwróci
        } else {
            LOG.log(Level.INFO, "Brak okna o id=" + id);
            return window.setId(-1);
        }
    }
}
