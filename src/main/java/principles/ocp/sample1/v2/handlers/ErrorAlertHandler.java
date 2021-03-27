package principles.ocp.sample1.v2.handlers;

import command_pattern_2.config.NotificationEmergencyLevel;
import command_pattern_2.domain.AlertRule;
import command_pattern_2.domain.Notification;
import principles.ocp.sample1.v2.ApiStatInfo;

public class ErrorAlertHandler extends AlertHandler {
    public ErrorAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        if (apiStatInfo.getErrorCount() > rule.getMatchedRule(apiStatInfo.getApi()).getMaxErrorCount()) {
            notification.notify(NotificationEmergencyLevel.SEVERE, "...");
        }
    }
}
