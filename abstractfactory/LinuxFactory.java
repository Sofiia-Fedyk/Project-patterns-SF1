package creational.abstractfactory;

class LinuxButton implements Button {
    @Override
    public void render() { System.out.println("  Rendering Linux button"); }
}

class LinuxCheckbox implements Checkbox {
    @Override
    public void render() { System.out.println("  Rendering Linux checkbox"); }
}

public class LinuxFactory implements GUIFactory {
    @Override
    public Button createButton() { return new LinuxButton(); }
    @Override
    public Checkbox createCheckbox() { return new LinuxCheckbox(); }
}
