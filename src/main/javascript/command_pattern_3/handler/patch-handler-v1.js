function PatchHandlerV1(preferenceAgent) {
    this.version = 1;
    this.preferenceAgent = preferenceAgent;
}

function patchV1(userPreference) {
    console.info('Patching in V1...');
    return userPreference;
}

PatchHandlerV1.prototype.handlePatch = function (userId) {
    console.info(`Patching preference data of user ${userId} in V1...`);
    const rawPreference = this.preferenceAgent.getUserPreference(userId);
    const newPreference = patchV1(rawPreference);
    this.preferenceAgent.setUserPreference(userId, newPreference);
    console.info('Patching in V1 is done');
};

module.exports = PatchHandlerV1;