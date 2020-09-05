package command_pattern_2.domain;

public class Rule {

    private final String api;

    public Rule(String api) {
        this.api = api;
    }

    public long getMaxTps() {
        //TODO
        return 1L;
    }

    public long getMaxErrorCount() {
        //TODO
        return 1L;
    }

    public long getMaxTimeoutCount() {
        //TODO
        return 1L;
    }

}
