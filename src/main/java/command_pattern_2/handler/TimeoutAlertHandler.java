package command_pattern_2.handler;

import command_pattern_2.config.NotificationEmergencyLevel;
import command_pattern_2.domain.AlertRule;
import command_pattern_2.domain.ApiStatInfo;
import command_pattern_2.domain.Notification;

public class TimeoutAlertHandler extends AlertHandler {

    public TimeoutAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        long timeoutCount = apiStatInfo.getTimeoutCount();
        if (timeoutCount > rule.getMatchedRule(apiStatInfo.getApi()).getMaxTimeoutCount()) {
            notification.notify(NotificationEmergencyLevel.URGENCY, "Timeout count is greater than the maximum!");
        }
    }

}
