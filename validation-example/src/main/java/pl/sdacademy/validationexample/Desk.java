package pl.sdacademy.validationexample;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Entity
public class Desk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Length(min = 1, max = 50)
    private String manufacturer;
    private boolean wooden;
    @Max(5)
    private int drawerCount;
    @NotNull
    private String color;
    @Column(unique = true)
    private String serialNo;

    public String getSerialNo() {
        return serialNo;
    }

    public String getColor() {
        return color;
    }

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
