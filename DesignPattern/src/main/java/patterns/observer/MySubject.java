package patterns.observer;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySubject implements Observable{

    private List<Observer> observers;
    private Logger logger;

    public MySubject() {
        this.observers = new ArrayList<Observer>();
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    public void registerObserver(Observer o) {
        logger.info("register observer: [{}]", o.getClass().getName());
        observers.add(o);
    }

    public void unregisterObserver(Observer o) {
        logger.info("unregister observer: [{}]", o.getClass().getName());
        observers.remove(0);
    }

    public void notify(Observer o, Object args) {
        o.update(args);
    }

    public void notify(Observer o) {
        o.update(this);
    }

    public void allNotify(Object args) {
        for(Observer o : observers) {
            o.update(args);
        }
    }

    public void allNotify() {
        for(Observer o : observers) {
            o.update(this);
        }
    }

    public void performActionInPushMode() {
        logger.info("perform onAction of [{}]", this.getClass().getName());
        allNotify("hello, i am your observable subject");
    }

    public void performActionInPullMode() {
        logger.info("perform onAction of [{}]", this.getClass().getName());
        allNotify();
    }

    public String getValueOne() {
        return "value one";
    }
}
