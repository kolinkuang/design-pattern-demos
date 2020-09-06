const {CurrentPatchedVersion} = require('./config/config');

function HandlerInvoker(isPrefBackupRequired) {
    this.handlerList = [];
    this.isPrefBackupRequired = isPrefBackupRequired;
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

    if (handler.constructor.name === 'PreHandler' && !this.isPrefBackupRequired) {
        console.info('Preference backup is skipped');
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

    // this.handlerList.filter(handler => handler.version < getCurrentPatchedVersion())
    //     .forEach(handler => handler.handlePatch());
}

module.exports = HandlerInvoker;