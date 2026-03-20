package structural.facade;

public class DVDPlayer {
    public void on()                { System.out.println("  DVD Player on"); }
    public void play(String movie)  { System.out.println("  Playing: " + movie); }
    public void stop()              { System.out.println("  DVD stopped"); }
    public void off()               { System.out.println("  DVD Player off"); }
}
