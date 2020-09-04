function Waiter() {

    let orders = [];

    const actionMap = {
        BakeChickenWingCommand(command) {
            console.warn(`No chicken wing, please ask something else!`);
        },
        BakeMuttonCommand(command) {
            orders.push(command);
            console.info(`Order is added: ${command.constructor.name}:${command.id} @ ${new Date()}`);
        },
        BakeCornCommand(command) {
            orders.push(command);
            console.info(`Order is added: ${command.constructor.name}:${command.id} @ ${new Date()}`);
        },
        default(command){
            console.info(`Command ${command.constructor.name} strategy not found`);
        }
    };

    function setOrder(command) {
        const fn = actionMap[command.constructor.name];
        typeof fn === 'function' ? fn(command) : actionMap['default'](command);
    }

    function cancelOrder(command) {
        orders = orders.filter(order => order.id === command.id);
        console.info(`Order is cancelled: ${command.constructor.name}:${command.id}`);
    }

    function notifyReceiver() {
        orders.forEach(order => order.executeCommand());
    }

    return {
        setOrder,
        cancelOrder,
        notifyReceiver
    };

}

module.exports = Waiter;