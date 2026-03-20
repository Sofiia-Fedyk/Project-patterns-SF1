package creational.abstractfactory;

class WindowsButton implements Button {
    @Override
    public void render() { System.out.println("  Rendering Windows button"); }
}

class WindowsCheckbox implements Checkbox {
    @Override
    public void render() { System.out.println("  Rendering Windows checkbox"); }
}

public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() { return new WindowsButton(); }
    @Override
    public Checkbox createCheckbox() { return new WindowsCheckbox(); }
}
