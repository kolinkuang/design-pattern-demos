package principles.di.v1;

public class MessageSender {

    public void send(String cellphone, String message) {
        System.out.printf("%s:%s", cellphone, message);
    }

}
