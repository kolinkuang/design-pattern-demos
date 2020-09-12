package principles.di.v3;

public class Demo {

    public static void main(String[] args) {
        MessageSender messageSender = new SmsSender();
        MessageSender messageSender2 = new InboxSender();
        Notification notification = new Notification(messageSender);
        Notification notification2 = new Notification(messageSender2);
        notification.sendMessage("hello", "world.3");
        notification2.sendMessage("hello", "world.4");
    }

}
