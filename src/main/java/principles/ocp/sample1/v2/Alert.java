package principles.ocp.sample1.v2;

import principles.ocp.sample1.v2.handlers.AlertHandler;

import java.util.ArrayList;
import java.util.List;

public class Alert {

    private final List<AlertHandler> alertHandlers = new ArrayList<>();

    public void addAlertHandler(AlertHandler alertHandler) {
        this.alertHandlers.add(alertHandler);
    }

    public void check(ApiStatInfo apiStatInfo) {
        for (AlertHandler handler : alertHandlers) {
            handler.check(apiStatInfo);
        }
    }

}
