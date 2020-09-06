const {CurrentPatchedVersion} = require('./config/config');

function HandlerInvoker() {
    this.handlerList = [];
}

function getCurrentPatchedVersion() {
    return CurrentPatchedVersion;
}

HandlerInvoker.prototype.addHandler = function (handler) {
    // Duck-typing
    if (typeof handler['handlePatch'] !== 'function' ||
        typeof handler['version'] !== 'number'
    ) {
        console.warn('Malformed handler!');
        return;
    }

    this.handlerList.push(handler);
};

HandlerInvoker.prototype.doPatch = function (userId) {
    // better performance
    for (let handler of this.handlerList) {
        if (handler.version <= getCurrentPatchedVersion()) {
            continue;
        }
        handler.handlePatch(userId);
    }
}

module.exports = HandlerInvoker;