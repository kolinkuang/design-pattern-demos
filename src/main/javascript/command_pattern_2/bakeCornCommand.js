const Command = require('./command');

class BakeCornCommand extends Command {

    constructor(receiver) {
        super();
        this.receiver = receiver;
    }

    executeCommand() {
        this.receiver.bakeCorn();
    }

}

module.exports = BakeCornCommand;