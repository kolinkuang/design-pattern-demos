function Barbecuer() {
}

Barbecuer.prototype.bakeMutton = function() {
    console.info('Bake mutton!');
};
Barbecuer.prototype.bakeChickenWing = function() {
    console.info('Bake chicken wing!');
};
Barbecuer.prototype.bakeCorn = function() {
    console.info('Bake corn!');
};

module.exports = Barbecuer;