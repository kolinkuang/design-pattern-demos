package generic_framework.v1;


import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Metrics {

    // Map的key是接口名称，value对应接口请求的响应时间或时间戳；
    private final Map<String, List<Double>> responseTime = new HashMap<>();
    private final Map<String, List<Double>> timestamps = new HashMap<>();
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public void recordResponseTime(String apiName, double responseTime) {
        this.responseTime.putIfAbsent(apiName, new ArrayList<>());
        this.responseTime.get(apiName).add(responseTime);
    }

    public void recordTimestamp(String apiName, double timestamp) {
        timestamps.putIfAbsent(apiName, new ArrayList<>());
        timestamps.get(apiName).add(timestamp);
    }

    public void startRepeatedReport(long period, TimeUnit unit) {
        executor.scheduleAtFixedRate(() -> {
            Gson gson = new Gson();
            Map<String, Map<String, Double>> stats = new HashMap<>();
            for (Map.Entry<String, List<Double>> entry : responseTime.entrySet()) {
                String apiName = entry.getKey();
                List<Double> apiRespTimes = entry.getValue();
                stats.putIfAbsent(apiName, new HashMap<>());
                stats.get(apiName).put("max", max(apiRespTimes));
                stats.get(apiName).put("avg", avg(apiRespTimes));
            }

            for (Map.Entry<String, List<Double>> entry : timestamps.entrySet()) {
                String apiName = entry.getKey();
                List<Double> apiTimestamps = entry.getValue();
                stats.putIfAbsent(apiName, new HashMap<>());
                stats.get(apiName).put("count", (double) apiTimestamps.size());
            }
            System.out.println(gson.toJson(stats));
        }, 0, period, unit);
    }

    private double max(List<Double> dataset) {
        //省略代码实现
        return 0;
    }

    private double avg(List<Double> dataset) {
        //省略代码实现
        return 0;
    }

}