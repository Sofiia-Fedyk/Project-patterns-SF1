package structural.facade;

// Facade — single entry point that orchestrates the complex subsystem
public class HomeTheaterFacade {
    private final Amplifier  amp;
    private final DVDPlayer  dvd;
    private final Projector  projector;
    private final Lights     lights;

    public HomeTheaterFacade(Amplifier amp, DVDPlayer dvd, Projector projector, Lights lights) {
        this.amp       = amp;
        this.dvd       = dvd;
        this.projector = projector;
        this.lights    = lights;
    }

    public void watchMovie(String movie) {
        System.out.println("  Preparing to watch \"" + movie + "\"...");
        lights.dim(10);
        projector.on();
        projector.setInput("DVD");
        amp.on();
        amp.setVolume(20);
        dvd.on();
        dvd.play(movie);
    }

    public void endMovie() {
        System.out.println("  Shutting down theater...");
        dvd.stop();
        dvd.off();
        amp.off();
        projector.off();
        lights.on();
    }
}
