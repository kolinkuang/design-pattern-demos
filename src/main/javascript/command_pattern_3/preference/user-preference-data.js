function UserPreferenceData() {}

UserPreferenceData.getData = function (userId) {
    return {
        hello: 'world'
    };
};

module.exports = UserPreferenceData;