package principles.ocp.sample1.v2;

import command_pattern_2.domain.AlertRule;
import command_pattern_2.domain.Notification;
import principles.ocp.sample1.v2.handlers.ErrorAlertHandler;
import principles.ocp.sample1.v2.handlers.TimeoutAlertHandler;
import principles.ocp.sample1.v2.handlers.TpsAlertHandler;

public class ApplicationContext {
    private Alert alert;

    public void initializeBeans() {
        /*.省略参数.*/
        AlertRule alertRule = new AlertRule(/*.省略参数.*/); //省略一些初始化代码
        /*.省略参数.*/
        Notification notification = new Notification(/*.省略参数.*/); //省略一些初始化代码
        alert = new Alert();
        alert.addAlertHandler(new TpsAlertHandler(alertRule, notification));
        alert.addAlertHandler(new ErrorAlertHandler(alertRule, notification));
        // 改动三：注册handler
        alert.addAlertHandler(new TimeoutAlertHandler(alertRule, notification));
    }
    public Alert getAlert() { return alert; }

    // 饿汉式单例
    private static final ApplicationContext instance = new ApplicationContext();
    private ApplicationContext() {
        initializeBeans();
    }
    public static ApplicationContext getInstance() {
        return instance;
    }
}