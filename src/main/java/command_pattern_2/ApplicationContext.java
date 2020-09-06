package command_pattern_2;

import command_pattern_2.domain.AlertRule;
import command_pattern_2.domain.Notification;
import command_pattern_2.handler.ErrorAlertHandler;
import command_pattern_2.handler.TimeoutAlertHandler;
import command_pattern_2.handler.TpsAlertHandler;

public class ApplicationContext {

    private Alert alert;

    private void initializeBeans() {
        // 负责组装 handler 与中介

        /*.省略参数.*/
        AlertRule alertRule = new AlertRule(/*.省略参数.*/); //省略一些初始化代码
        /*.省略参数.*/
        Notification notification = new Notification(/*.省略参数.*/); //省略一些初始化代码
        alert = new Alert();
        alert.addAlertHandler(new TpsAlertHandler(alertRule, notification));
        alert.addAlertHandler(new ErrorAlertHandler(alertRule, notification));
        alert.addAlertHandler(new TimeoutAlertHandler(alertRule, notification));
    }

    // 饿汉式单例
    private static final ApplicationContext instance = new ApplicationContext();

    private ApplicationContext() {
        initializeBeans();
    }

    public static ApplicationContext getInstance() {
        return instance;
    }

    public Alert getAlert() { return alert; }

}
