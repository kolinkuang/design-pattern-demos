const PreferenceAgent = require('./preference/preference-agent');
const HandlerInvokerWrapper = require('./handler-invoker-wrapper');
const PreHandler = require('./handler/pre-handler');
const PatchHandlerV1 = require('./handler/patch-handler-v1');
const PatchHandlerV2 = require('./handler/patch-handler-v2');
const PatchHandlerV3 = require('./handler/patch-handler-v3');
const PostHandler = require('./handler/post-handler');

module.exports = (function ContextController() {

    let instance;

    function init(isPrefBackupRequired) {
        // 每个 handler 对 preference data 处理有副作用，上一 handler 输出为下一 handler 输入；
        // 所以用命令模式真是最佳选择？
        const preferenceAgent = new PreferenceAgent();
        const handlerInvoker = new HandlerInvokerWrapper(isPrefBackupRequired);
        const preHandler = new PreHandler(preferenceAgent);
        const patchHandlerV1 = new PatchHandlerV1(preferenceAgent);
        const patchHandlerV2 = new PatchHandlerV2(preferenceAgent);
        const patchHandlerV3 = new PatchHandlerV3(preferenceAgent);
        const postHandler = new PostHandler(preferenceAgent);
        handlerInvoker.addPreHandler(preHandler);
        handlerInvoker.addHandler(patchHandlerV1);
        handlerInvoker.addHandler(patchHandlerV2);
        handlerInvoker.addHandler(patchHandlerV3);
        handlerInvoker.addPostHandler(postHandler);

        return {
            _getInvoker: () => handlerInvoker
        };
    }

    return {
        getInvoker: isPrefBackupRequired => {
            if (!instance) {
                instance = init(isPrefBackupRequired);
            }
            return instance._getInvoker();
        }
    };
})();