package structural.facade;

public class Projector {
    public void on()                    { System.out.println("  Projector on"); }
    public void setInput(String input)  { System.out.println("  Projector input: " + input); }
    public void off()                   { System.out.println("  Projector off"); }
}
