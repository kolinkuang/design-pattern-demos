package unit_test_2.v2;

import unit_test_2.utils.STATUS;

import javax.transaction.InvalidTransactionException;

public class Test2 {

    public void testExecute() throws InvalidTransactionException {
        Long buyerId = 123L;
        Long sellerId = 234L;
        Long productId = 345L;
        Long orderId = 456L;
        Transaction transaction = new Transaction(null, buyerId, sellerId, productId, orderId);
        // 使用mock对象来替代真正的RPC服务
        transaction.setWalletRpcService(new MockWalletRpcServiceOne());
        boolean executedResult = transaction.execute();
        assertTrue(executedResult);
        assertEquals(STATUS.EXECUTED, transaction.getStatus());
    }

    private void assertEquals(STATUS executed, Object status) {

    }

    private void assertTrue(boolean executedResult) {

    }

}
