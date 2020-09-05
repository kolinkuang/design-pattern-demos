package command_pattern_2;

import command_pattern_2.domain.ApiStatInfo;
import command_pattern_2.handler.AlertHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * 告警中介
 * **/
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