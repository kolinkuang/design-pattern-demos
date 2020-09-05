package command_pattern_2;

import command_pattern_2.domain.ApiStatInfo;

/**
 * 接口监控告警
 * */
public class Demo {

    public static void main(String[] args) {
        ApiStatInfo apiStatInfo = new ApiStatInfo();
        apiStatInfo.setApi("Dummy API");
        apiStatInfo.setDurationOfSeconds(1);
        apiStatInfo.setErrorCount(10);
        apiStatInfo.setRequestCount(10);
        apiStatInfo.setTimeoutCount(289);
        // ...省略设置apiStatInfo数据值的代码
        ApplicationContext.getInstance().getAlert().check(apiStatInfo);
    }

}
