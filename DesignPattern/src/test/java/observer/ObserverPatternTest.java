package observer;

import org.junit.Before;
import org.junit.Test;
import patterns.observer.*;

public class ObserverPatternTest {

    Observable observable = new MySubject();
    Observer observer1 = new ObserverOne();
    Observer observer2 = new ObserverTwo();

    @Before
    public void setUp() throws Exception {

        observable.registerObserver(observer1);
        observable.registerObserver(observer2);
    }

    @Test
    public void testPushMode() {


        ((MySubject) observable).performActionInPushMode();

        observable.unregisterObserver(observer2);
        ((MySubject) observable).performActionInPushMode();
    }

    @Test
    public void testPullMode() {

        ((MySubject) observable).performActionInPullMode();

        observable.unregisterObserver(observer2);
        ((MySubject) observable).performActionInPullMode();
    }
}
