package command_pattern_2.domain;

/**
* 存储告警规则
* */
public class AlertRule {

    public Rule getMatchedRule(String api) {
        //TODO
        return new Rule(api);
    }

}
