function Command() {

    this.id = Math.floor(Math.random() * 999_999_999);

}

Command.prototype.constructor = Command;

module.exports = Command;