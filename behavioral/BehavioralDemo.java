package behavioral;

import behavioral.chainofresponsibility.Handler;
import behavioral.chainofresponsibility.LowLevelSupport;
import behavioral.chainofresponsibility.MidLevelSupport;
import behavioral.chainofresponsibility.HighLevelSupport;
import behavioral.command.Light;
import behavioral.command.RemoteControl;
import behavioral.command.TurnOffCommand;
import behavioral.command.TurnOnCommand;
import behavioral.iterator.Book;
import behavioral.iterator.BookCollection;
import behavioral.iterator.BookIterator;
import behavioral.mediator.AdminUser;
import behavioral.mediator.ChatMediator;
import behavioral.mediator.ChatRoom;
import behavioral.mediator.RegularUser;
import behavioral.mediator.User;
import behavioral.memento.History;
import behavioral.memento.TextEditor;
import behavioral.observer.EmailNotifier;
import behavioral.observer.EventManager;
import behavioral.observer.LogNotifier;
import behavioral.observer.SMSNotifier;
import behavioral.state.TrafficLight;
import behavioral.strategy.BubbleSortStrategy;
import behavioral.strategy.MergeSortStrategy;
import behavioral.strategy.QuickSortStrategy;
import behavioral.strategy.Sorter;
import behavioral.templatemethod.CSVProcessor;
import behavioral.templatemethod.JSONProcessor;
import behavioral.visitor.AreaCalculator;
import behavioral.visitor.Circle;
import behavioral.visitor.Rectangle;
import behavioral.visitor.Shape;
import behavioral.visitor.Triangle;

import java.util.List;

public class BehavioralDemo {

    private static void demonstrateChainOfResponsibility() {
        System.out.println("Chain of Responsibility Pattern:");
        Handler low  = new LowLevelSupport();
        Handler mid  = new MidLevelSupport();
        Handler high = new HighLevelSupport();

        // Build the chain: low -> mid -> high
        low.setNext(mid).setNext(high);

        System.out.println(low.handle(1, "Password reset"));
        System.out.println(low.handle(2, "Account locked"));
        System.out.println(low.handle(3, "Data breach alert"));
        System.out.println(low.handle(4, "Unknown issue"));
        System.out.println("Each request travels the chain until a handler accepts it\n");
    }

    private static void demonstrateCommand() {
        System.out.println("Command Pattern:");
        Light livingRoomLight = new Light("Living room");
        RemoteControl remote  = new RemoteControl();

        remote.press(new TurnOnCommand(livingRoomLight));
        remote.press(new TurnOnCommand(new Light("Bedroom")));
        remote.press(new TurnOffCommand(livingRoomLight));
        remote.undoLast();
        System.out.println("Requests encapsulated as objects with undo support\n");
    }

    private static void demonstrateIterator() {
        System.out.println("Iterator Pattern:");
        BookCollection collection = new BookCollection();
        collection.addBook(new Book("Clean Code", "Robert C. Martin"));
        collection.addBook(new Book("Design Patterns", "Gang of Four"));
        collection.addBook(new Book("Refactoring", "Martin Fowler"));

        BookIterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println("  " + iterator.next());
        }
        System.out.println("Collection traversed without exposing its internal structure\n");
    }

    private static void demonstrateMediator() {
        System.out.println("Mediator Pattern:");
        ChatMediator chatRoom = new ChatRoom();

        User alice = new RegularUser(chatRoom, "Alice");
        User bob   = new RegularUser(chatRoom, "Bob");
        User admin = new AdminUser(chatRoom, "Admin");

        chatRoom.addUser(alice);
        chatRoom.addUser(bob);
        chatRoom.addUser(admin);

        alice.send("Hello everyone!");
        admin.send("Welcome to the channel.");
        System.out.println("Users communicate through a central mediator, not directly\n");
    }

    private static void demonstrateMemento() {
        System.out.println("Memento Pattern:");
        TextEditor editor  = new TextEditor();
        History    history = new History();

        editor.type("Hello");
        history.push(editor.save());
        System.out.println("  Typed: " + editor.getContent());

        editor.type(", World");
        history.push(editor.save());
        System.out.println("  Typed: " + editor.getContent());

        editor.type("!!!");
        System.out.println("  Typed: " + editor.getContent());

        editor.restore(history.pop());
        System.out.println("  Undo:  " + editor.getContent());

        editor.restore(history.pop());
        System.out.println("  Undo:  " + editor.getContent());

        System.out.println("Editor state saved and restored without breaking encapsulation\n");
    }

    private static void demonstrateObserver() {
        System.out.println("Observer Pattern:");
        EventManager manager = new EventManager();

        manager.subscribe("login",  new EmailNotifier("admin@example.com"));
        manager.subscribe("login",  new LogNotifier());
        manager.subscribe("purchase", new EmailNotifier("sales@example.com"));
        manager.subscribe("purchase", new SMSNotifier("+1-555-0100"));
        manager.subscribe("purchase", new LogNotifier());

        System.out.println("  -- login event --");
        manager.notify("login", "user: john_doe");

        System.out.println("  -- purchase event --");
        manager.notify("purchase", "item: Java Book, $49.99");

        System.out.println("Observers notified automatically on events they subscribe to\n");
    }

    private static void demonstrateState() {
        System.out.println("State Pattern:");
        TrafficLight light = new TrafficLight();
        System.out.println("  Current: " + light.getCurrentColor());
        light.change();
        light.change();
        light.change();
        light.change();
        System.out.println("  Current: " + light.getCurrentColor());
        System.out.println("Object behaviour changed by delegating to the current state object\n");
    }

    private static void demonstrateStrategy() {
        System.out.println("Strategy Pattern:");
        int[] data1 = {5, 3, 8, 1, 9, 2};
        int[] data2 = {5, 3, 8, 1, 9, 2};
        int[] data3 = {5, 3, 8, 1, 9, 2};

        Sorter sorter = new Sorter();

        sorter.setStrategy(new BubbleSortStrategy());
        sorter.sort(data1);

        sorter.setStrategy(new QuickSortStrategy());
        sorter.sort(data2);

        sorter.setStrategy(new MergeSortStrategy());
        sorter.sort(data3);

        System.out.println("Algorithm swapped at runtime without changing the client code\n");
    }

    private static void demonstrateTemplateMethod() {
        System.out.println("Template Method Pattern:");
        System.out.println("  Processing CSV:");
        new CSVProcessor().process("name,age,city");

        System.out.println("  Processing JSON:");
        new JSONProcessor().process("{\"name\":\"Alice\",\"age\":\"30\"}");

        System.out.println("Skeleton algorithm defined once; subclasses fill in the steps\n");
    }

    private static void demonstrateVisitor() {
        System.out.println("Visitor Pattern:");
        List<Shape> shapes = List.of(
            new Circle(5),
            new Rectangle(4, 6),
            new Triangle(3, 8)
        );

        AreaCalculator calculator = new AreaCalculator();
        for (Shape shape : shapes) {
            shape.accept(calculator);
        }
        System.out.println("New operation (area) added to shapes without modifying shape classes\n");
    }

    public static void run() {
        demonstrateChainOfResponsibility();
        demonstrateCommand();
        demonstrateIterator();
        demonstrateMediator();
        demonstrateMemento();
        demonstrateObserver();
        demonstrateState();
        demonstrateStrategy();
        demonstrateTemplateMethod();
        demonstrateVisitor();
    }
}
