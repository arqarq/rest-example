package pl.sdacademy.restexample;

import javax.persistence.*;

@Entity
@Table(name = "`window`") // "window" okazało się słowem kluczowym w nowym MySQL
public class Window {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int width;
    private int height;

    public Window(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Window() {
        super();
    }

    public long getId() {
        return id;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
