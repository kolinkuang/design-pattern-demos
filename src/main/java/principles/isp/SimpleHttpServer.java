package principles.isp;

import principles.isp.config.Viewer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleHttpServer {

    private final String host;
    private final int port;
    private final Map<String, List<Viewer>> viewers = new HashMap<>();

    public SimpleHttpServer(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void addViewer(String urlDirectory, Viewer viewer) {
        if (!viewers.containsKey(urlDirectory)) {
            viewers.put(urlDirectory, new ArrayList<>());
        }
        this.viewers.get(urlDirectory).add(viewer);
    }

    public void run() {
        System.out.printf("Running SimpleHttpServer on %s:%s\n", host, port);
        viewers.forEach((key, value) -> value.forEach(viewer -> System.out.printf("%s:%s\n", key, viewer.outputInPlainText())));
    }

}
