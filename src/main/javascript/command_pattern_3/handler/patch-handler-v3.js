function PatchHandlerV3(preferenceAgent) {
    this.version = 3;
    this.preferenceAgent = preferenceAgent;
}

function patchV3(userPreference) {
    return userPreference;
}

PatchHandlerV3.prototype.handlePatch = function (userId) {
    console.info(`Patching preference data of user ${userId} in V3...`);
    const rawPreference = this.preferenceAgent.getUserPreference(userId);
    const newPreference = patchV3(rawPreference);
    this.preferenceAgent.setUserPreference(userId, newPreference);
    console.info('Patching in V3 is done');
};

module.exports = PatchHandlerV3;