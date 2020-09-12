package principles.isp.config;

import principles.isp.source.ConfigSource;

import java.util.HashMap;
import java.util.Map;

public class MySqlConfig implements Viewer {

    private final ConfigSource configSource; //配置中心（比如zookeeper）
    private String address;
    private int timeout;
    private int maxTotal;

    public MySqlConfig(ConfigSource configSource) {
        this.configSource = configSource;
        init();
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

    private void init() {
        address = configSource.getAddress();
        timeout = configSource.getTimeout();
        maxTotal = configSource.getMaxTotal();
    }

    @Override
    public String outputInPlainText() {
        return output().toString();
    }

    @Override
    public Map<String, String> output() {
        return new HashMap<String, String>() {{
            put("Address", getAddress());
            put("Timeout", String.valueOf(getTimeout()));
            put("MaxTotal", String.valueOf(getMaxTotal()));
        }};
    }

}
