package command_pattern_2.handler;

import command_pattern_2.domain.AlertRule;
import command_pattern_2.domain.ApiStatInfo;
import command_pattern_2.domain.Notification;

public abstract class AlertHandler {

    protected AlertRule rule;
    protected Notification notification;

    public AlertHandler(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    public abstract void check(ApiStatInfo apiStatInfo);

}
