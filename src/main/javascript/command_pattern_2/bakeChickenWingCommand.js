const Command = require('./command');

class BakeChickenWingCommand extends Command {

    constructor(receiver) {
        super();
        this.receiver = receiver;
    }

    executeCommand() {
        this.receiver.bakeChickenWing();
    }

}
module.exports = BakeChickenWingCommand;