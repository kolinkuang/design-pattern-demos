const HandlerInvoker = require('./handler-invoker');

function HandlerInvokerWrapper(isPrefBackupRequired) {
    this.isPrefBackupRequired = isPrefBackupRequired;
    this.handlerInvoker = new HandlerInvoker();
    this.preHandler = null;
    this.postHandler = null;
}

function isValidHandler(handler) {
    return typeof handler['handlePatch'] === 'function';
}

HandlerInvokerWrapper.prototype.addPreHandler = function (preHandler) {
    if (!isValidHandler(preHandler)) {
        console.warn('Malformed handler!');
        return;
    }

    this.preHandler = preHandler;
};

HandlerInvokerWrapper.prototype.addHandler = function (handler) {
    this.handlerInvoker.addHandler(handler);
}

HandlerInvokerWrapper.prototype.addPostHandler = function (postHandler) {
    if (!isValidHandler(postHandler)) {
        console.warn('Malformed handler!');
        return;
    }

    this.postHandler = postHandler;
};

HandlerInvokerWrapper.prototype.doPatch = function (userId) {
    if (this.isPrefBackupRequired) {
        this.preHandler.handlePatch(userId);
    } else {
        console.info('Preference backup is skipped');
    }

    this.handlerInvoker.doPatch(userId);

    this.postHandler.handlePatch(userId);
};

module.exports = HandlerInvokerWrapper;