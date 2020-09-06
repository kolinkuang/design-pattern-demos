function PreHandler(preferenceAgent) {
    this.version = 0;
    this.preferenceAgent = preferenceAgent;
}

function backupPreference(userId, rawPrefData) {
    console.info(`Backing up preference data of user ${userId}...`);
    this.preferenceAgent.setUserPreference(userId, rawPrefData);
    // do the backup right here...
    console.info(`Preference data of user ${userId} is backed up into file`);
}

PreHandler.prototype.handlePatch = function (userId) {
    const userPreference = this.preferenceAgent.getUserPreference(userId);
    backupPreference.call(this, userId, userPreference);
};

module.exports = PreHandler;