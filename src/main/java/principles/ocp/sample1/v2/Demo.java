package principles.ocp.sample1.v2;

public class Demo {
    public static void main(String[] args) {
        ApiStatInfo apiStatInfo = new ApiStatInfo();
        // ...省略设置apiStatInfo数据值的代码
        apiStatInfo.setTimeoutCount(289); // 改动四：设置tiemoutCount值
        ApplicationContext.getInstance().getAlert().check(apiStatInfo);
    }
}
