package creational.abstractfactory;

class MacButton implements Button {
    @Override
    public void render() { System.out.println("  Rendering Mac button"); }
}

class MacCheckbox implements Checkbox {
    @Override
    public void render() { System.out.println("  Rendering Mac checkbox"); }
}

public class MacFactory implements GUIFactory {
    @Override
    public Button createButton() { return new MacButton(); }
    @Override
    public Checkbox createCheckbox() { return new MacCheckbox(); }
}
