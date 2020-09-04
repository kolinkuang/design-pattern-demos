const Barbecuer = require('./barbecuer');
const BakeMuttonCommand = require('./bakeMuttonCommand');
const BakeChickenWingCommand = require('./bakeChickenWingCommand');
const Waiter = require('./waiter');

const boy = new Barbecuer();
const girl = new Waiter();
const bakeMuttonCommand1 = new BakeMuttonCommand(boy);
const bakeMuttonCommand2 = new BakeMuttonCommand(boy);
const bakeChickenWingCommand = new BakeChickenWingCommand(boy);

girl.setOrder(bakeMuttonCommand1);
girl.setOrder(bakeMuttonCommand2);
girl.setOrder(bakeChickenWingCommand);
// girl.cancelOrder(bakeChickenWingCommand);

girl.notifyReceiver();