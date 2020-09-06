const Command = require('./command');

function BakeChickenWingCommand(receiver) {
    Command.call(this);
    // 子类方法写到构造函数里实现不了原型继承，原型链也会丢失
    this.receiver = receiver;
}

//复制而不是直接引用父类原型对象
BakeChickenWingCommand.prototype = Object.create(Command.prototype);
BakeChickenWingCommand.prototype.constructor = BakeChickenWingCommand;
BakeChickenWingCommand.prototype.executeCommand = function () {
    this.receiver.bakeChickenWing();
};

module.exports = BakeChickenWingCommand;