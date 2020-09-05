package command_pattern_2.domain;

import command_pattern_2.config.NotificationEmergencyLevel;

/**
* 告警通知：支持邮件、短信、微信、手机等多种通知渠道
 *
 * Final implementer
 *
* */
public class Notification {

    public void notify(NotificationEmergencyLevel level, String message) {
        System.out.printf("%s:%s\n", level.toString(), message);
    }

}
