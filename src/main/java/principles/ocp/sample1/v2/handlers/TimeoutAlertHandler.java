package principles.ocp.sample1.v2.handlers;

import command_pattern_2.domain.AlertRule;
import command_pattern_2.domain.Notification;
import principles.ocp.sample1.v2.ApiStatInfo;

// 改动二：添加新的handler
public class TimeoutAlertHandler extends AlertHandler {
    public TimeoutAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }//省略代码...

    @Override
    public void check(ApiStatInfo apiStatInfo) {

    }
}

