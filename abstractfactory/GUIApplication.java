package creational.abstractfactory;

public class GUIApplication {
    private final Button button;
    private final Checkbox checkbox;

    public GUIApplication(GUIFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void interact() {
        button.render();
        checkbox.render();
    }
}
