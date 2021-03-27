package principles.ocp.sample2;

import command_pattern_2.domain.Notification;

public class Demo {
    private final MessageQueue msgQueue; // 基于接口而非实现编程

    public Demo(MessageQueue msgQueue) { // 依赖注入
        this.msgQueue = msgQueue;
    }

    // msgFormatter：多态、依赖注入
    public void sendNotification(Notification notification, MessageFormatter msgFormatter) {
        //...
    }
}
