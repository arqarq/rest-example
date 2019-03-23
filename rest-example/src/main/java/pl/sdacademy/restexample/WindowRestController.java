package pl.sdacademy.restexample;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/windows")
public class WindowRestController {
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
        Window windowById = windowRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brak okna o zadanym id"));
        windowRepository.delete(windowById);
        return windowById; // dla konsoli firefox - brak błędy gdy coś zwróci
    }
}
