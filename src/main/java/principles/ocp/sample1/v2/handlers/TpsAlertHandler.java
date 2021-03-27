package principles.ocp.sample1.v2.handlers;

import command_pattern_2.config.NotificationEmergencyLevel;
import command_pattern_2.domain.AlertRule;
import command_pattern_2.domain.Notification;
import principles.ocp.sample1.v2.ApiStatInfo;

public class TpsAlertHandler extends AlertHandler {
    public TpsAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        long tps = apiStatInfo.getRequestCount()/ apiStatInfo.getDurationOfSeconds();
        if (tps > rule.getMatchedRule(apiStatInfo.getApi()).getMaxTps()) {
            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
        }
    }
}