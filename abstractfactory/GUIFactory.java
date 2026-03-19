package creational.abstractfactory;

interface Button {
    void render();
}

interface Checkbox {
    void render();
}

public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
