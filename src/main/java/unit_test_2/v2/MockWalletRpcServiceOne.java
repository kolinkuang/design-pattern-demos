package unit_test_2.v2;

import unit_test_2.utils.WalletRpcService;

public class MockWalletRpcServiceOne extends WalletRpcService {

    public String moveMoney(Long id, Long fromUserId, Long toUserId, Double amount) {
        return "123bac";
    }

}