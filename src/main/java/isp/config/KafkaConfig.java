package isp.config;

import isp.source.ConfigSource;

public class KafkaConfig implements Updater {

    private final ConfigSource configSource; //配置中心（比如zookeeper）
    private String address;
    private int timeout;
    private int maxTotal;

    public KafkaConfig(ConfigSource configSource) {
        this.configSource = configSource;
    }

    public String getAddress() {
        return this.address;
    }

    public int getTimeout() {
        return timeout;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    @Override
    public void update() {
        //从 configSource 加载配置到address/timeout/maxTotal...
        address = configSource.getAddress();
        timeout = configSource.getTimeout();
        maxTotal = configSource.getMaxTotal();
        System.out.printf("Kafka config update is done: address=%s, timeout=%s, maxTotal=%s\n", this.getAddress(), this.getTimeout(), this.getMaxTotal());
    }

}
