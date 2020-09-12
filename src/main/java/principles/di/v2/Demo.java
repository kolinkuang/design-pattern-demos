package principles.di.v2;

public class Demo {

    public static void main(String[] args) {
        MessageSender messageSender = new MessageSender();
        Notification notification = new Notification(messageSender);
        notification.sendMessage("hello", "world.2");
    }

}
