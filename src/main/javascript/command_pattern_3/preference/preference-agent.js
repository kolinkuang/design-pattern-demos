const UserPreferenceData = require('./user-preference-data');

function PreferenceAgent () {
    this.preferenceCache = {};
}

PreferenceAgent.prototype.getUserPreference = function (userId) {
    // console.info(`Getting preference data of user ${userId}`);
    return this.preferenceCache[userId] || UserPreferenceData.getData(userId);
};

PreferenceAgent.prototype.setUserPreference = function (userId, preferenceData) {
    // console.info(`Setting preference data of user ${userId}`);
    this.preferenceCache[userId] = preferenceData;
};

module.exports = PreferenceAgent;