function Barbecuer() {

    function bakeMutton() {
        console.info('Bake mutton!');
    }

    function bakeChickenWing() {
        console.info('Bake chicken wing!');
    }

    return {
        bakeMutton,
        bakeChickenWing
    };

}

module.exports = Barbecuer;