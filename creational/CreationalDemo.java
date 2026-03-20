package creational;

import creational.singleton.Singleton;
import creational.factory.Transport;
import creational.factory.TransportFactory;
import creational.factorymethod.Application;
import creational.factorymethod.PDFApplication;
import creational.factorymethod.WordApplication;
import creational.factorymethod.ExcelApplication;
import creational.abstractfactory.GUIFactory;
import creational.abstractfactory.GUIApplication;
import creational.abstractfactory.WindowsFactory;
import creational.abstractfactory.MacFactory;
import creational.abstractfactory.LinuxFactory;
import creational.builder.Computer;
import creational.prototype.Shape;
import creational.prototype.ShapePrototypeRegistry;

public class CreationalDemo {

    private static void demonstrateSingleton() {
        System.out.println("1. SINGLETON");

        Singleton singleton1 = Singleton.getInstance("First instance");
        Singleton singleton2 = Singleton.getInstance("Second instance");

        System.out.println("singleton1.getValue() = " + singleton1.getValue());
        System.out.println("singleton2.getValue() = " + singleton2.getValue());
        System.out.println("singleton1 == singleton2: " + (singleton1 == singleton2));
        System.out.println("Both variables point to the same object\n");
    }

    private static void demonstrateFactory() {
        System.out.println("2. FACTORY");

        Transport truck = TransportFactory.createTransport("truck");
        truck.deliver();

        Transport ship = TransportFactory.createTransport("ship");
        ship.deliver();

        Transport airplane = TransportFactory.createTransport("airplane");
        airplane.deliver();

        System.out.println("Objects created via factory without knowing the concrete class\n");
    }

    private static void demonstrateFactoryMethod() {
        System.out.println("3. FACTORY METHOD");

        Application pdfApp = new PDFApplication();
        System.out.println("PDF Application:");
        pdfApp.newDocument();

        Application wordApp = new WordApplication();
        System.out.println("\nWord Application:");
        wordApp.newDocument();

        Application excelApp = new ExcelApplication();
        System.out.println("\nExcel Application:");
        excelApp.newDocument();

        System.out.println("Each app creates its own document type\n");
    }

    private static void demonstrateAbstractFactory() {
        System.out.println("4. ABSTRACT FACTORY");

        GUIFactory windowsFactory = new WindowsFactory();
        GUIApplication windowsApp = new GUIApplication(windowsFactory);
        System.out.println("Windows UI:");
        windowsApp.interact();

        GUIFactory macFactory = new MacFactory();
        GUIApplication macApp = new GUIApplication(macFactory);
        System.out.println("\nMac UI:");
        macApp.interact();

        GUIFactory linuxFactory = new LinuxFactory();
        GUIApplication linuxApp = new GUIApplication(linuxFactory);
        System.out.println("\nLinux UI:");
        linuxApp.interact();

        System.out.println("Each factory produces a matching set of UI components\n");
    }

    private static void demonstrateBuilder() {
        System.out.println("5. BUILDER");

        Computer gamingPC = new Computer.ComputerBuilder("Intel Core i9")
                .setGpu("NVIDIA RTX 4090")
                .setRam(32)
                .setStorage(2000)
                .setWifi(true)
                .setBluetooth(true)
                .build();

        System.out.println("Gaming PC:");
        System.out.println(gamingPC);

        Computer budgetPC = new Computer.ComputerBuilder("AMD Ryzen 5")
                .setRam(8)
                .setStorage(512)
                .setWifi(true)
                .build();

        System.out.println("\nBudget PC:");
        System.out.println(budgetPC);

        System.out.println("Objects built step by step using Builder\n");
    }

    private static void demonstratePrototype() {
        System.out.println("6. PROTOTYPE");

        ShapePrototypeRegistry registry = new ShapePrototypeRegistry();

        Shape circlePrototype = new Shape("Circle", 100, 100, "Red");
        Shape rectanglePrototype = new Shape("Rectangle", 50, 50, "Blue");

        registry.registerPrototype("red-circle", circlePrototype);
        registry.registerPrototype("blue-rectangle", rectanglePrototype);

        registry.displayRegistry();

        System.out.println("\nCloning prototypes:");
        Shape clonedCircle1 = registry.getShape("red-circle");
        clonedCircle1.setPosition(200, 200);
        System.out.println("  Circle 1: " + clonedCircle1);

        Shape clonedCircle2 = registry.getShape("red-circle");
        clonedCircle2.setPosition(300, 300);
        clonedCircle2.setColor("Green");
        System.out.println("  Circle 2: " + clonedCircle2);

        Shape clonedRectangle = registry.getShape("blue-rectangle");
        clonedRectangle.setPosition(150, 150);
        System.out.println("  Rectangle: " + clonedRectangle);

        System.out.println("\nNew objects created by cloning existing ones\n");
    }

    public static void run() {
        demonstrateSingleton();
        demonstrateFactory();
        demonstrateFactoryMethod();
        demonstrateAbstractFactory();
        demonstrateBuilder();
        demonstratePrototype();
    }
}
