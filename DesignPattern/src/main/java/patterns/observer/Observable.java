package patterns.observer;

public interface Observable {

    void registerObserver(Observer o);
    void unregisterObserver(Observer o);
    void notify(Observer o, Object args);
    void allNotify();
}
