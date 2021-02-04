package observer_pattern.observers;

import observer_pattern.Subject;

// 观察者
public abstract class Observer {

    protected Subject subject;

    public abstract void update();

}
