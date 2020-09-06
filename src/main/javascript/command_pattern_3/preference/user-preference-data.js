function UserPreferenceData() {}

UserPreferenceData.getData = function (userId) {
    return {
        userId,
        hello: 'world'
    };
};

module.exports = UserPreferenceData;