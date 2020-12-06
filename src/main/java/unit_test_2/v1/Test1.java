package unit_test_2.v1;

import javax.transaction.InvalidTransactionException;

public class Test1 {

    public void testExecute() throws InvalidTransactionException {
        Long buyerId = 123L;
        Long sellerId = 234L;
        Long productId = 345L;
        Long orderId = 456L;
        Transaction transaction = new Transaction(null, buyerId, sellerId, productId, orderId);
        boolean executedResult = transaction.execute();
        assertTrue(executedResult);
    }

    private void assertTrue(boolean executedResult) {

    }

}
