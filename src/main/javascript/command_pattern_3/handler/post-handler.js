function PostHandler(preferenceAgent) {
    this.version = 1000;
    this.preferenceAgent = preferenceAgent;
}

function saveToEvolveService(userId, rawPrefData) {
    console.info(`Saving preference data of user ${userId} to Evolve service...`);
    // send preference data to evolve service...
    console.info(`Preference data of user ${userId}: ${JSON.stringify(rawPrefData)} has been sent to Evolve service`);
}

PostHandler.prototype.handlePatch = function (userId) {
    const userPreference = this.preferenceAgent.getUserPreference(userId);
    saveToEvolveService.call(this, userId, userPreference);
};

module.exports = PostHandler;