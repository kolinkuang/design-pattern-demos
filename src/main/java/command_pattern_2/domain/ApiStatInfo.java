package command_pattern_2.domain;

public class ApiStatInfo {

    private String api;
    private long requestCount;
    private long errorCount;
    private long durationOfSeconds;
    private long timeoutCount;

    public ApiStatInfo() {
    }

    public String getApi() {
        return api;
    }

    public long getRequestCount() {
        return requestCount;
    }

    public long getErrorCount() {
        return errorCount;
    }

    public long getDurationOfSeconds() {
        return durationOfSeconds;
    }

    public long getTimeoutCount() {
        return timeoutCount;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public void setRequestCount(long requestCount) {
        this.requestCount = requestCount;
    }

    public void setErrorCount(long errorCount) {
        this.errorCount = errorCount;
    }

    public void setDurationOfSeconds(long durationOfSeconds) {
        this.durationOfSeconds = durationOfSeconds;
    }

    public void setTimeoutCount(long timeoutCount) {
        this.timeoutCount = timeoutCount;
    }

}
