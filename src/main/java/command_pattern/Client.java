package command_pattern;

public class Client {

    public static void main(String[] args) {
        Barbecuer boy = new Barbecuer();
        BakeMuttonCommand bakeMuttonCommand1 = new BakeMuttonCommand(boy);
        BakeMuttonCommand bakeMuttonCommand2 = new BakeMuttonCommand(boy);
        BakeChickenWingCommand bakeChickenWingCommand = new BakeChickenWingCommand(boy);
        Waiter girl = new Waiter();

        girl.setOrder(bakeMuttonCommand1);
        girl.setOrder(bakeMuttonCommand2);
        girl.setOrder(bakeChickenWingCommand);
        girl.cancelOrder(bakeChickenWingCommand);

        girl.notifyReceiver();
    }
    
}
