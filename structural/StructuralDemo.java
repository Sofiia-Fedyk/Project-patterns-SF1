package structural;

import structural.adapter.LegacyPaymentAdapter;
import structural.adapter.LegacyPaymentSystem;
import structural.adapter.PaymentProcessor;
import structural.bridge.AdvancedRemote;
import structural.bridge.BasicRemote;
import structural.bridge.Radio;
import structural.bridge.TV;
import structural.composite.File;
import structural.composite.Folder;
import structural.decorator.Coffee;
import structural.decorator.MilkDecorator;
import structural.decorator.SimpleCoffee;
import structural.decorator.SugarDecorator;
import structural.decorator.WhipDecorator;
import structural.facade.Amplifier;
import structural.facade.DVDPlayer;
import structural.facade.HomeTheaterFacade;
import structural.facade.Lights;
import structural.facade.Projector;
import structural.flyweight.Forest;
import structural.flyweight.TreeFactory;
import structural.proxy.Internet;
import structural.proxy.ProxyInternet;

public class StructuralDemo {

    private static void demonstrateAdapter() {
        System.out.println("Adapter Pattern:");
        // Wrap the old system so it can be used via the new PaymentProcessor interface
        PaymentProcessor processor = new LegacyPaymentAdapter(new LegacyPaymentSystem());
        processor.processPayment("USD", 150.00);
        processor.processPayment("EUR", 89.50);
        System.out.println("Old payment system used through the new interface\n");
    }

    private static void demonstrateBridge() {
        System.out.println("Bridge Pattern:");
        // BasicRemote + TV
        BasicRemote tvRemote = new BasicRemote(new TV());
        tvRemote.turnOn();
        tvRemote.setVolume(15);
        tvRemote.turnOff();

        // AdvancedRemote + Radio — same remote type, different device
        AdvancedRemote radioRemote = new AdvancedRemote(new Radio());
        radioRemote.turnOn();
        radioRemote.mute();
        System.out.println("Remote types and device types vary independently\n");
    }

    private static void demonstrateComposite() {
        System.out.println("Composite Pattern:");
        Folder root = new Folder("Documents");
        root.add(new File("resume.pdf", 120));

        Folder projects = new Folder("Projects");
        projects.add(new File("Main.java", 15));
        projects.add(new File("README.md", 8));

        Folder assets = new Folder("Assets");
        assets.add(new File("logo.png", 340));
        projects.add(assets);

        root.add(projects);
        root.display("");
        System.out.println("Files and folders treated through the same interface\n");
    }

    private static void demonstrateDecorator() {
        System.out.println("Decorator Pattern:");
        Coffee coffee = new SimpleCoffee();
        System.out.println("  " + coffee.getDescription() + " -> $" + String.format("%.2f", coffee.getCost()));

        coffee = new MilkDecorator(coffee);
        System.out.println("  " + coffee.getDescription() + " -> $" + String.format("%.2f", coffee.getCost()));

        coffee = new SugarDecorator(coffee);
        System.out.println("  " + coffee.getDescription() + " -> $" + String.format("%.2f", coffee.getCost()));

        coffee = new WhipDecorator(coffee);
        System.out.println("  " + coffee.getDescription() + " -> $" + String.format("%.2f", coffee.getCost()));

        System.out.println("Behaviour added at runtime by wrapping objects\n");
    }

    private static void demonstrateFacade() {
        System.out.println("Facade Pattern:");
        HomeTheaterFacade theater = new HomeTheaterFacade(
            new Amplifier(), new DVDPlayer(), new Projector(), new Lights()
        );
        theater.watchMovie("Inception");
        theater.endMovie();
        System.out.println("Complex subsystem controlled through a single facade\n");
    }

    private static void demonstrateFlyweight() {
        System.out.println("Flyweight Pattern:");
        Forest forest = new Forest();
        forest.plantTree(10, 20, "Oak",  "Green",     "oak_texture");
        forest.plantTree(30, 40, "Oak",  "Green",     "oak_texture"); // reuses existing flyweight
        forest.plantTree(50, 60, "Pine", "DarkGreen", "pine_texture");
        forest.plantTree(70, 80, "Oak",  "Green",     "oak_texture"); // reuses again
        forest.plantTree(90, 10, "Pine", "DarkGreen", "pine_texture"); // reuses Pine flyweight
        forest.draw();
        System.out.println("  " + forest.getTreeCount() + " trees drawn using only "
            + TreeFactory.getCachedCount() + " shared TreeType objects\n");
    }

    private static void demonstrateProxy() {
        System.out.println("Proxy Pattern:");
        Internet internet = new ProxyInternet();
        internet.connectTo("google.com");
        internet.connectTo("gambling.com");
        internet.connectTo("github.com");
        internet.connectTo("malware.com");
        System.out.println("Proxy intercepted requests and blocked restricted sites\n");
    }

    public static void run() {
        demonstrateAdapter();
        demonstrateBridge();
        demonstrateComposite();
        demonstrateDecorator();
        demonstrateFacade();
        demonstrateFlyweight();
        demonstrateProxy();
    }
}
