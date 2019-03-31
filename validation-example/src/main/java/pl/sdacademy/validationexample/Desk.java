package pl.sdacademy.validationexample;

import javax.persistence.*;

@Entity
public class Desk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String manufacturer;
    private boolean wooden;
    private int drawerCount;

    public Long getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public boolean isWooden() {
        return wooden;
    }

    public int getDrawerCount() {
        return drawerCount;
    }
}
