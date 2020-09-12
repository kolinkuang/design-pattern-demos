package principles.isp;

import principles.isp.config.KafkaConfig;
import principles.isp.config.MySqlConfig;
import principles.isp.config.RedisConfig;
import principles.isp.scheduler.ScheduledUpdater;
import principles.isp.source.ConfigSource;
import principles.isp.source.ZookeeperConfigSource;

public class Application {

    private static final ConfigSource configSource = new ZookeeperConfigSource("localhost", 10, 10);
    public static final RedisConfig redisConfig = new RedisConfig(configSource);
    public static final KafkaConfig kafkaConfig = new KafkaConfig(configSource);
    public static final MySqlConfig mysqlConfig = new MySqlConfig(configSource);

    public static void main(String[] args) {
        ScheduledUpdater redisConfigUpdater = new ScheduledUpdater(redisConfig, 3, 3);
        redisConfigUpdater.run();

        ScheduledUpdater kafkaConfigUpdater = new ScheduledUpdater(kafkaConfig, 6, 6);
        kafkaConfigUpdater.run();

        SimpleHttpServer simpleHttpServer = new SimpleHttpServer("127.0.0.1", 2389);
        simpleHttpServer.addViewer("/config", redisConfig);
        simpleHttpServer.addViewer("/config", mysqlConfig);
        simpleHttpServer.run();
    }

}
