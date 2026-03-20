package structural.proxy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Proxy controls access to RealInternet — blocks restricted sites
public class ProxyInternet implements Internet {
    private final Internet realInternet = new RealInternet();

    private static final Set<String> BLOCKED = new HashSet<>(Arrays.asList(
        "gambling.com", "malware.com"
    ));

    @Override
    public void connectTo(String url) {
        System.out.println("  [Proxy] Request intercepted: " + url);
        if (BLOCKED.contains(url.toLowerCase())) {
            System.out.println("  [Proxy] Access denied: " + url + " is blocked");
        } else {
            System.out.println("  [Proxy] Access granted, forwarding...");
            realInternet.connectTo(url); // forward to real subject
        }
    }
}
