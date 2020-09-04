const Command = require('./command');

class BakeMuttonCommand extends Command {

    constructor(receiver) {
        super();
        this.receiver = receiver;
    }

    executeCommand() {
        this.receiver.bakeMutton();
    }

}

module.exports = BakeMuttonCommand;