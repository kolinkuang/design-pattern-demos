package principles.ioc.v2;

public class Demo {

    public static void main(String[] args) {
        // 注册操作还可以通过配置的方式来实现，不需要程序员显示调用register()
        JunitApplication.register(new UserServiceTest());
        JunitApplication.run();
    }

}