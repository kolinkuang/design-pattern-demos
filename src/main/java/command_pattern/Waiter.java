package command_pattern;

import java.util.*;
import java.util.function.Consumer;

public class Waiter{

    private final List<Command> orders = new ArrayList<>();

    private final Map<String, Consumer<Command>> actionMap = new HashMap<String, Consumer<Command>>(){{
        put("class command_pattern.BakeChickenWingCommand", command ->
                System.out.println("No chicken wing, please ask something else!"));
        put("class command_pattern.BakeMuttonCommand", command -> {
            orders.add(command);
            System.out.printf("Order is added: %s @ %s \n", command.toString(), new Date());
        });
    }};

    public void setOrder(Command command) {
        actionMap.get(command.getClass().toString()).accept(command);
    }

    public void cancelOrder(Command command) {
        orders.remove(command);
        System.out.printf("Order is removed: %s @ %s \n", command.toString(), new Date());
    }

    public void notifyReceiver() {
        orders.forEach(Command::executeCommand);
    }

}