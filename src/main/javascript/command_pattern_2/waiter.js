class Waiter {

    constructor() {
        this.orders = [];
        this.actionMap = {
            BakeChickenWingCommand(command) {
                console.warn(`No chicken wing, please ask something else!`);
            },
            BakeMuttonCommand(command) {
                this.orders.push(command);
                console.info(`Order is added: ${command.constructor.name}:${command.id} @ ${new Date()}`);
            },
            BakeCornCommand(command) {
                this.orders.push(command);
                console.info(`Order is added: ${command.constructor.name}:${command.id} @ ${new Date()}`);
            },
            default(command){
                console.info(`Command ${command.constructor.name} strategy not found`);
            }
        };
    }

    setOrder(command) {
        const fn = this.actionMap[command.constructor.name];
        typeof fn === 'function' ? fn.call(this, command) : this.actionMap['default'].call(this, command);
    }

    cancelOrder(command) {
        this.orders = this.orders.filter(order => order.id === command.id);
        console.info(`Order is cancelled: ${command.constructor.name}:${command.id}`);
    }

    notifyReceiver() {
        this.orders.forEach(order => order.executeCommand());
    }

}

module.exports = Waiter;