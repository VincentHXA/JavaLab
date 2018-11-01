package patterns.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObserverTwo implements Observer{

    private Logger logger;

    public ObserverTwo() {
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    public void update(Observable observable) {
        MySubject subject = (MySubject) observable;
        String value = subject.getValueOne();
        logger.info("[{}] pull data: [{}] from [{}]", this.getClass().getName(), value, observable.getClass().getName());
    }

    public void update(Object args) {
        logger.info("[{}] received info: [{}]", this.getClass().getName(), args);
    }
}
