function PatchHandlerV2(preferenceAgent) {
    this.version = 2;
    this.preferenceAgent = preferenceAgent;
}

function patchV2(userPreference) {
    return userPreference;
}

PatchHandlerV2.prototype.handlePatch = function (userId) {
    console.info(`Patching preference data of user ${userId} in V2...`);
    const rawPreference = this.preferenceAgent.getUserPreference(userId);
    const newPreference = patchV2(rawPreference);
    this.preferenceAgent.setUserPreference(userId, newPreference);
    console.info('Patching in V2 is done');
};

module.exports = PatchHandlerV2;