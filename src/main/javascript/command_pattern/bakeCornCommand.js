const Command = require('./command');

function BakeCornCommand(receiver) {
    Command.call(this);
    // 子类方法写到构造函数里实现不了原型继承，原型链也会丢失
    this.receiver = receiver;
}

BakeCornCommand.prototype = Object.create(Command.prototype);
BakeCornCommand.prototype.constructor = BakeCornCommand;
BakeCornCommand.prototype.executeCommand = function () {
    this.receiver.bakeCorn();
};

module.exports = BakeCornCommand;