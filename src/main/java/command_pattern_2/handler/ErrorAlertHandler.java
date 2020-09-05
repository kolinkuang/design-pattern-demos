package command_pattern_2.handler;

import command_pattern_2.config.NotificationEmergencyLevel;
import command_pattern_2.domain.AlertRule;
import command_pattern_2.domain.ApiStatInfo;
import command_pattern_2.domain.Notification;

public class ErrorAlertHandler extends AlertHandler {

    public ErrorAlertHandler(AlertRule rule, Notification notification){
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        if (apiStatInfo.getErrorCount() > rule.getMatchedRule(apiStatInfo.getApi()).getMaxErrorCount()) {
            notification.notify(NotificationEmergencyLevel.SEVERE, "Error count is larger than the maximum!");
        }
    }

}
