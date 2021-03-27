package principles.ocp.sample1.v2.handlers;

import command_pattern_2.domain.AlertRule;
import command_pattern_2.domain.Notification;
import principles.ocp.sample1.v2.ApiStatInfo;

public abstract class AlertHandler {
    protected AlertRule rule;
    protected Notification notification;
    public AlertHandler(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }
    public abstract void check(ApiStatInfo apiStatInfo);
}
