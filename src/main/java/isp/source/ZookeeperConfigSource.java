package isp.source;

public class ZookeeperConfigSource implements ConfigSource {

    private final String address;
    private final int timeout;
    private final int maxTotal;

    public ZookeeperConfigSource(String address, int timeout, int maxTotal) {
        this.address = address;
        this.timeout = timeout;
        this.maxTotal = maxTotal;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public int getTimeout() {
        return timeout;
    }

    @Override
    public int getMaxTotal() {
        return maxTotal;
    }

}
