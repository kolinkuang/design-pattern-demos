const Command = require('./command');

function BakeMuttonCommand(receiver) {
    Command.call(this);
    // 子类方法写到构造函数里实现不了原型继承，原型链也会丢失
    this.receiver = receiver;
}

BakeMuttonCommand.prototype = Object.create(Command.prototype);
BakeMuttonCommand.prototype.constructor = BakeMuttonCommand;
BakeMuttonCommand.prototype.executeCommand = function () {
    this.receiver.bakeMutton();
};

module.exports = BakeMuttonCommand;