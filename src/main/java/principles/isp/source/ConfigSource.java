package principles.isp.source;

public interface ConfigSource {

    String getAddress();
    int getTimeout();
    int getMaxTotal();

}
