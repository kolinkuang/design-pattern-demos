package observer_pattern;

import observer_pattern.observers.Observer;

import java.util.ArrayList;
import java.util.List;

// 主题（被依赖对象）
public class Subject {

    private final List<Observer> observers = new ArrayList<>();
    private int state;  // 响应式数据

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        // 依赖触发
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        // 依赖收集
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

}
