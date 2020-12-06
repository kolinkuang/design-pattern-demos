package unit_test_2.utils;

public class RedisDistributedLock {

    public static RedisDistributedLock getSingletonInstance() {
        return new RedisDistributedLock();
    }

    public boolean lockTransaction(String id) {
        return false;
    }


    public void unlockTransaction(String id) {

    }

}
