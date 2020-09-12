package principles.di.v3;

// 站内信发送类
public class InboxSender implements MessageSender {

    @Override
    public void send(String cellphone, String message) {
        System.out.printf("Sending Inbox message: %s\n", message);
    }

}
