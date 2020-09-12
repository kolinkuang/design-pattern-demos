package principles.di.v3;

// 短信发送类
public class SmsSender implements MessageSender {

    @Override
    public void send(String cellphone, String message) {
        System.out.printf("Sending SMS: %s\n", message);
    }

}
