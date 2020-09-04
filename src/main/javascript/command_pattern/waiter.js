function Waiter() {

    let orders = [];

    const actionMap = {
        BakeChickenWingCommand(command) {
            console.warn('No chicken wing, please ask something else!');
        },
        BakeMuttonCommand(command) {
            orders.push(command);
            console.info(`Order is added: ${command} @ ${new Date()}`);
        },
        default(command){
            console.info(`Command ${command} strategy not found`);
        }
    };

    function setOrder(command) {
        const fn = actionMap[command.constructor.name];
        typeof fn === 'function' ? fn(command) : actionMap['default'](command);
    }

    function cancelOrder(command) {
        orders = orders.filter(order => order.id === command.id);
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