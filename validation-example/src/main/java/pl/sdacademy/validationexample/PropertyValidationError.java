package pl.sdacademy.validationexample;

public class PropertyValidationError {
    private String property;
    private String message;

    public PropertyValidationError(String property, String message) {
        this.property = property;
        this.message = message;
    }

    public String getProperty() {
        return property;
    }

    public String getMessage() {
        return message;
    }
}
