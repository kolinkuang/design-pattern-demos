package principles.ocp.sample1.v1;

import command_pattern_2.config.NotificationEmergencyLevel;
import command_pattern_2.domain.AlertRule;
import command_pattern_2.domain.Notification;

public class Alert {

    private final AlertRule rule;
    private final Notification notification;

    public Alert(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    public void check(String api, long requestCount, long errorCount, long durationOfSeconds) {
        long tps = requestCount / durationOfSeconds;
        if (tps > rule.getMatchedRule(api).getMaxTps()) {
            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
        }
        if (errorCount > rule.getMatchedRule(api).getMaxErrorCount()) {
            notification.notify(NotificationEmergencyLevel.SEVERE, "...");
        }
    }

}
